package com.dinhlap.javaspring.service.corejava2;

import java.util.Set;

public interface Exercise2Service {
    /** Bài tập 2: HashSet Hãy tạo một chương trình Java để thực hiện các thao tác cơ bản trên một HashSet.
    Hãy tạo một HashSet chứa tên của các quốc gia và thực hiện các thao tác sau:
    Thêm các tên quốc gia vào HashSet.
    Hiển thị danh sách các quốc gia đã thêm vào.
    Kiểm tra xem một quốc gia có tồn tại trong HashSet hay không.
    Xóa một quốc gia cụ thể khỏi HashSet.
    Tính số lượng các quốc gia có trong HashSet.
*/
    Set<String> addCountry(String country);
    void displayCountry();
    boolean checkCountry(String country);
    Set<String> removeCountry(String country);
    int countCountry();
}
