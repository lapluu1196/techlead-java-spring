package com.dinhlap.javaspring.service.corejava4;

import com.dinhlap.javaspring.entity.javacore4.Employee;
import com.dinhlap.javaspring.entity.javacore4.Shift;
import com.dinhlap.javaspring.entity.javacore4.WorkingDay;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class CoreJava4ServiceImpl implements CoreJava4Service {
    public final int COLUMN_INDEX_ID = 1;
    public final int COLUMN_INDEX_NAME = 2;

    private final List<Employee> employees = new ArrayList<>();
    private final List<WorkingDay> workingDays = new ArrayList<>();
    private final List<Shift> shifts = new ArrayList<>();

    @Override
    public Workbook getWorkbook(InputStream is, String excelPath) throws IOException {
        return excelPath.endsWith("xlsx") ? new XSSFWorkbook(is) : new HSSFWorkbook(is);
    }

    @Override
    public boolean isRowEmpty(Row row) {
        for (int cellNum = 0; cellNum < row.getLastCellNum(); cellNum++) {
            Cell cell = row.getCell(cellNum);
            if (cell != null && cell.getCellType() != CellType.BLANK) {
                return false;
            }
        }
        return true;
    }

    public boolean isColumnEmpty(Sheet sheet, int column) {
        for (int row = 0; row < sheet.getLastRowNum(); row++) {
            Row currentRow = sheet.getRow(row);
            if (currentRow != null && currentRow.getCell(column) != null && currentRow.getCell(column).getCellType() != CellType.BLANK) {
                return false;
            }
        }
        return true;
    }

    @Override
    public Object getCellValue(Cell cell) {
        CellType cellType = cell.getCellType();
        Object cellValue = null;
        switch (cellType) {
            case STRING:
                cellValue = cell.getStringCellValue();
                break;
            case NUMERIC:
                cellValue = cell.getNumericCellValue();
                break;
            case BOOLEAN:
                cellValue = cell.getBooleanCellValue();
                break;
            case FORMULA:
                Workbook workbook = cell.getSheet().getWorkbook();
                FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
                cellValue = evaluator.evaluate(cell).getNumberValue();
                break;
            case _NONE:
            case BLANK:
            case ERROR:
            default:
                return null;
        }

        return cellValue;
    }

    @Override
    public int getTotalAmountColumn(Sheet sheet) {
        int totalSalaryColumn = 0;
        for (int i = 0; i < sheet.getRow(3).getLastCellNum(); i++) {
            Cell cell = sheet.getRow(3).getCell(i);
            if (cell.getCellType() == CellType.STRING && cell.getStringCellValue().equalsIgnoreCase("Tổng lương")) {
                totalSalaryColumn = cell.getColumnIndex();
            }
        }
        return totalSalaryColumn;
    }

    @Override
    public Map<Integer, List<Integer>> getColDayRange(Sheet sheet, int totalSalaryColumn) {
        Map<Integer, List<Integer>> colDayRange = new LinkedHashMap<>();
        Row dayRow = sheet.getRow(3);
        int currentDay = -1;
        List<Integer> dayRange = new ArrayList<>();

        for (int i = totalSalaryColumn + 1; i < dayRow.getLastCellNum(); i++) {
            if (isColumnEmpty(sheet, i)) {
                continue;
            }
            Cell cell = dayRow.getCell(i);
            if (cell != null) {
                String cellValue = "";
                if (cell.getCellType() == CellType.NUMERIC) {
                    cellValue = String.valueOf((int) cell.getNumericCellValue());
                } else if (cell.getCellType() == CellType.STRING) {
                    cellValue = cell.getStringCellValue().trim();
                }

                try {
                    int dayNumber = Integer.parseInt(cellValue);
                    if (dayNumber != currentDay) {
                        if (currentDay != -1 && !dayRange.isEmpty()) {
                            colDayRange.put(currentDay, new ArrayList<>(dayRange));
                            dayRange.clear();
                        }
                        currentDay = dayNumber;
                    }
                    dayRange.add(i);
                } catch (NumberFormatException e) {
                    if (currentDay != -1) {
                        dayRange.add(i);
                    }
                }
            }
        }
        if (!dayRange.isEmpty()) {
            colDayRange.put(currentDay, dayRange);
        }

        return colDayRange;
    }

    @Override
    public Map<String, Double> shiftsRate(Sheet sheet, int totalSalaryColumn, int employeeRow) {
        Map<String, Double> shiftsRate = new LinkedHashMap<>();
        for (int j = 3; j < totalSalaryColumn; j++) {
            String shiftName = sheet.getRow(5).getCell(j).getStringCellValue().trim();
            if (!shiftName.isEmpty() && !shiftName.equalsIgnoreCase("$")) {
                if (shiftName.contains("WK")) {
                    shiftsRate.put(shiftName, sheet.getRow(employeeRow).getCell(totalSalaryColumn - 1).getNumericCellValue());
                } else {
                    shiftsRate.put(shiftName, sheet.getRow(employeeRow).getCell(j + 1).getNumericCellValue());
                }
            }
        }
        return shiftsRate;
    }

    @Override
    public Shift getShift(Sheet sheet, Map<String, Double> shiftsRate, int colDayRange, int employeeRow) {
        String shiftName = sheet.getRow(5).getCell(colDayRange).getStringCellValue();

        if (shiftName != null && !shiftName.equalsIgnoreCase("$")) {
            double hours = 0.0;
            Cell shiftCell = sheet.getRow(employeeRow).getCell(colDayRange);
            if (shiftCell != null && shiftCell.getCellType() == CellType.NUMERIC) {
                hours = shiftCell.getNumericCellValue();
            }
            if (!shiftsRate.containsKey(shiftName)) {
                shiftsRate.put(shiftName + " - Not defined!", 0.0);
                shiftName = shiftName + " - Not defined!";
            }
            double rate = shiftsRate.getOrDefault(shiftName, 0.0);
            double amount = rate * hours;
            return new Shift(shiftName, hours, amount);
        }
        return null;
    }

    @Override
    public WorkingDay getWorkingDay(Sheet sheet, Map<String, Double> shiftsRate, int day, List<Integer> colIndexRange, int employeeRow) {
        WorkingDay workingDay = new WorkingDay(String.valueOf(day));
        for (int colIndex : colIndexRange) {
            Shift shift = getShift(sheet, shiftsRate, colIndex, employeeRow);
            if (shift != null) {
                workingDay.addShift(shift, shift.getHours(), shift.getAmount());
            }
        }
        return workingDay;
    }

    @Override
    public Employee getEmployee(Sheet sheet, Map<String, Double> shiftsRate, Map<Integer, List<Integer>> colDayRange, int employeeRow, int totalSalaryColumn) {
        Row employeeRowData = sheet.getRow(employeeRow);

        String employeeId = employeeRowData.getCell(COLUMN_INDEX_ID).getStringCellValue();
        String employeeName = employeeRowData.getCell(COLUMN_INDEX_NAME).getStringCellValue();

        Employee employee = new Employee(employeeId, employeeName, employeeRowData.getCell(totalSalaryColumn).getNumericCellValue());
        employee.setShiftsRate(shiftsRate);

        return employee;
    }

    @Override
    public List<Employee> readTimesheet(String filePath) throws IOException {
        List<Employee> employees = new ArrayList<>();

        try (InputStream is = new FileInputStream(new File(filePath))) {
            Workbook workbook = getWorkbook(is, filePath);
            Sheet sheet = workbook.getSheetAt(0);

            int totalSalaryColumn = getTotalAmountColumn(sheet);

            Map<Integer, List<Integer>> colIndexRangeOfWorkingDay = getColDayRange(sheet, totalSalaryColumn);

            for (int i = 6; i < sheet.getLastRowNum(); i++) {
                Row row = sheet.getRow(i);

                Map<String, Double> shiftsRate = shiftsRate(sheet, totalSalaryColumn, i);

                List<WorkingDay> workingDays = new ArrayList<>();

                for (Map.Entry<Integer, List<Integer>> entry : colIndexRangeOfWorkingDay.entrySet()) {
                    WorkingDay workingDay = getWorkingDay(sheet, shiftsRate, entry.getKey(), entry.getValue(), i);
                    workingDays.add(workingDay);
                }

                Employee employee = new Employee(row.getCell(COLUMN_INDEX_ID).getStringCellValue(),
                        row.getCell(COLUMN_INDEX_NAME).getStringCellValue(),
                        row.getCell(totalSalaryColumn).getNumericCellValue());

                employee.setShiftsRate(shiftsRate);
                for (WorkingDay workingDay: workingDays) {
                    employee.addWorkingDay(workingDay);
                }
                employees.add(employee);
            }
        }

        return employees;
    }
}
