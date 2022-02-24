package com.example.demo.prd.converter;

import com.example.demo.cus.dto.CusCustomerDto;
import com.example.demo.cus.dto.CusCustomerSaveRequestDto;
import com.example.demo.cus.dto.CusCustomerUpdateRequestDto;
import com.example.demo.cus.entity.CusCustomer;
import com.example.demo.prd.dto.PrdProductDto;
import com.example.demo.prd.dto.PrdProductSaveRequestDto;
import com.example.demo.prd.dto.PrdProductUpdate;
import com.example.demo.prd.entity.PrdProduct;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PrdProductMapper {
    PrdProductMapper INSTANCE = Mappers.getMapper(PrdProductMapper.class);
    PrdProduct convertToPrdProduct(PrdProductSaveRequestDto prdProductSaveRequestDto);

    PrdProduct convertToPrdProduct(PrdProductUpdate prdProductUpdate);

    PrdProductDto convertToPrdProductDto(PrdProduct prdProduct);



}
