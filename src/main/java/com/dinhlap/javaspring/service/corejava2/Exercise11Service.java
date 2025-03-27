package com.dinhlap.javaspring.service.corejava2;

import java.util.Dictionary;

public interface Exercise11Service {
    /**
     * Bài 11: Tạo từ điển đơn giản Hãy tạo một từ điển đơn giản sử dụng HashMap. Cho phép người dùng
     * thêm từ và định nghĩa của từ vào từ điển. Sau đó, cho phép người dùng tra cứu từ
     * điển bằng cách nhập từ cần tìm kiếm và hiển thị định nghĩa của từ đó.
     */
    String searchWord(String word);
    void addWord(String word, String meaning);
}
