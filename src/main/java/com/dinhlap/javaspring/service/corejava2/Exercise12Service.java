package com.dinhlap.javaspring.service.corejava2;

import com.dinhlap.javaspring.entity.javacore2.Product12;

import java.util.Set;

public interface Exercise12Service {
    /** Chúng ta có 1 list/set các các sản phẩm bao gồm các thông tin tên, mã, giá bán,
    ngày sản xuất. Hãy viết 1 đoạn chương trình để sắp xếp các sản phẩm theo các tiêu chí sau:
    Theo tên
    Theo giá bán
    Theo ngày sản xuất
    Theo giá bán và ngày sản xuất*/

    Set<Product12> sortProduct(int option);
}
