package com.dinhlap.javaspring.service.corejava2;

import java.util.List;

public interface Exercise1Service {
    /** Bài tập 1: ArrayList Hãy tạo một chương trình Java để thực hiện các thao tác cơ bản trên một ArrayList.
    Hãy bắt đầu với một ArrayList chứa các số nguyên và thực hiện các thao tác sau:
    Thêm các phần tử vào ArrayList.
    Hiển thị các phần tử trong ArrayList.
    Tính tổng của tất cả các phần tử trong ArrayList.
    Tìm giá trị lớn nhất và nhỏ nhất trong ArrayList.
    Xóa một phần tử cụ thể khỏi ArrayList.
    Kiểm tra một phần tử có tồn tại trong ArrayList hay không.*/

    List<Integer> addElementToList(int element);
    String displayElementsInList();
    int sumOfElementsInList();
    int maxElementInList();
    int minElementInList();
    List<Integer> removeElementFromList(int element);
    boolean checkElementInList(int element);
}
