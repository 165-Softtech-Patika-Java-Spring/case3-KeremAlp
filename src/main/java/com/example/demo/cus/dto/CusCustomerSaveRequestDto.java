package com.example.demo.cus.dto;

import lombok.Data;


@Data
public class CusCustomerSaveRequestDto {

    private String name;
    private String surname;
    private Long identityNo;
    private String email;
    private String phone;
    private String password;
}
