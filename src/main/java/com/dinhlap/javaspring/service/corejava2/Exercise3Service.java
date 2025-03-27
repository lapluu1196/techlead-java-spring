package com.dinhlap.javaspring.service.corejava2;

import java.util.Map;

public interface Exercise3Service {
/** Bài tập 3: HashMap Hãy tạo một chương trình Java để thực hiện các thao tác cơ bản trên một HashMap.
    Hãy tạo một HashMap để lưu trữ cặp key-value với key là tên của một người và value là tuổi của người đó.
    Thực hiện các thao tác sau:
    Thêm các cặp key-value vào HashMap.
    Hiển thị danh sách tên của tất cả các người trong HashMap.
    Tìm tuổi của một người dựa trên tên của họ.
    Xóa một người cụ thể khỏi HashMap.
    Kiểm tra xem một người có tồn tại trong HashMap hay không.
*/
    Map<String, Integer> addPerson(String name, int age);
    void displayPerson();
    int findAge(String name);
    Map<String, Integer> removePerson(String name);
    boolean checkPerson(String name);
}
