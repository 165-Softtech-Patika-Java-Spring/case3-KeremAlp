package com.example.demo.cus.dto;

import com.example.demo.gen.enums.GenStatusType;
import lombok.Data;


@Data
public class CusCustomerDto {

    private Long id;
    private String name;
    private String surname;
    private String email;
    private String phone;
    private Long identityNo;
    private GenStatusType statusType;
}
