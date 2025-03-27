package com.dinhlap.javaspring.service.corejava4;

import com.dinhlap.javaspring.entity.javacore4.Shift;
import com.dinhlap.javaspring.entity.javacore4.WorkingDay;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

public interface CoreJava4Service {
    Workbook getWorkbook(InputStream is, String excelPath) throws IOException;
    boolean isRowEmpty(Row row);
    Object getCellValue(Cell cell);
    int getTotalAmountColumn(Sheet sheet);
    Map<Integer, List<Integer>> getColDayRange(Sheet sheet, int totalSalaryColumn);
    Map<String, Double> shiftsRate(Sheet sheet, int totalSalaryColumn, int employeeRow);
    List<WorkingDay> getListOfWorkingDay(Sheet sheet, Map<String, Double> shiftsRate, Map<Integer, List<Integer>> colDayRange, int employeeRow, int totalSalaryColumn);
    Shift getShift(Sheet sheet, Map<String, Double> shiftsRate, int colDayRange, int employeeRow);
    WorkingDay getWorkingDay(Sheet sheet, List<Shift> shifts, int colDayRange, int employeeRow);
}
