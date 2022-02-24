package com.example.demo.prd.service;

import com.example.demo.cus.converter.CusCustomerMapper;
import com.example.demo.cus.dto.CusCustomerDto;
import com.example.demo.cus.dto.CusCustomerSaveRequestDto;
import com.example.demo.cus.dto.CusCustomerUpdateRequestDto;
import com.example.demo.cus.entity.CusCustomer;
import com.example.demo.prd.converter.PrdProductConverter;
import com.example.demo.prd.converter.PrdProductMapper;
import com.example.demo.prd.dto.PrdProductDto;
import com.example.demo.prd.dto.PrdProductSaveRequestDto;
import com.example.demo.prd.dto.PrdProductUpdate;
import com.example.demo.prd.entity.PrdProduct;
import com.example.demo.prd.service.entityservice.PrdProductEntityService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PrdProductService {
    private final PrdProductConverter prdProductConverter;
    private final PrdProductEntityService prdProductEntityService;

    public List<PrdProductDto> findAll() {

        List<PrdProduct> prdProducts = prdProductEntityService.findAll();

        List<PrdProductDto> prdProductDtoList = prdProductConverter.convertToPrdProductDtoList(prdProducts);

        return prdProductDtoList;
    }

    public PrdProductDto save(PrdProductSaveRequestDto prdProductSaveRequestDto) {

        PrdProduct prdProduct = PrdProductMapper.INSTANCE.convertToPrdProduct(prdProductSaveRequestDto);

        prdProduct = prdProductEntityService.save(prdProduct);

        PrdProductDto prdProductDto = PrdProductMapper.INSTANCE.convertToPrdProductDto(prdProduct);

        return prdProductDto;
    }


    public void delete(Long id) {


        PrdProduct prdProduct = prdProductEntityService.findById(id).get();
        prdProductEntityService.delete(prdProduct);
    }


    public PrdProductDto findById(Long id) {

        PrdProduct prdProduct = prdProductEntityService.getByIdWithControl(id);

        return PrdProductMapper.INSTANCE.convertToPrdProductDto(prdProduct);
    }

    public PrdProductDto update(PrdProductUpdate prdProductUpdate) {


        PrdProduct prdProduct;
        prdProduct = PrdProductMapper.INSTANCE.convertToPrdProduct(prdProductUpdate);
        prdProductEntityService.save(prdProduct);

        PrdProductDto prdProductDto = PrdProductMapper.INSTANCE.convertToPrdProductDto(prdProduct);

        return prdProductDto;
    }


}
