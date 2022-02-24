package com.example.demo.cus.dto;

import lombok.Data;


@Data
public class CusCustomerDto {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private Long identityNo;
}
