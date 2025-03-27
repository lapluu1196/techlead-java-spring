package com.dinhlap.javaspring.service.corejava2;

import com.dinhlap.javaspring.entity.javacore2.Product8;

public interface Exercise8Service {
    /** Bài tập 8: Quản lý danh sách sản phẩm Hãy tạo một ứng dụng quản lý danh sách sản phẩm sử dụng HashMap.
    Mỗi sản phẩm có một mã sản phẩm làm key và thông tin sản phẩm làm value (ví dụ: tên sản phẩm, giá, số lượng).
    Hãy cung cấp các chức năng sau:
    Thêm sản phẩm mới vào danh sách.
    Hiển thị danh sách tất cả các sản phẩm.
    Tìm thông tin sản phẩm dựa trên mã sản phẩm.
    Xóa sản phẩm khỏi danh sách dựa trên mã sản phẩm.
    Cập nhật thông tin sản phẩm.*/
    void addProduct(Product8 newProduct);
    void showProduct();
    Product8 searchProduct(String code);
    void deleteProduct(String code);
    void updateProduct(Product8 updateProduct);
}
