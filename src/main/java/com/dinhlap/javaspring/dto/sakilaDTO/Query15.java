package com.dinhlap.javaspring.dto.sakilaDTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Query15 {
    private String firstName;
    private String lastName;
    private String address;
    private String address2;
    private String district;
    private Integer cityId;
    private String postalCode;
    private String phone;
}
