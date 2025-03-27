package com.dinhlap.javaspring.service.corejava2;

import java.util.List;
import java.util.Map;

public interface Exercise9And10Service {
    /** Đếm số lần xuất hiện của các từ trong một văn bản Hãy viết một chương trình Java
    để đọc một đoạn văn bản từ người dùng và đếm số lần xuất hiện của mỗi từ trong văn bản.
    Sử dụng HashMap để lưu trữ từ làm key và số lần xuất hiện làm value. Sau đó,
    hiển thị danh sách các từ và số lần xuất hiện tương ứng của chúng.*/
    Map<String, Integer> countWords(String sentence);

    /** Bài tập 10: Kiểm tra phân phối điểm số Hãy viết một chương trình Java để kiểm tra
    phân phối điểm số của một lớp học. Người dùng sẽ nhập danh sách điểm số của sinh viên
    và chương trình sẽ tính số lượng sinh viên đạt điểm cao (>= 8.0),
    số lượng sinh viên đạt điểm trung bình (>= 5.0 và < 8.0) và số lượng sinh viên trượt (dưới 5.0).
    Sử dụng HashMap để lưu trữ điểm số làm key và số lượng sinh viên đạt điểm tương ứng làm value.*/
    Map<String, Integer> checkScore(Map<String, List<Double>> scores);
}
