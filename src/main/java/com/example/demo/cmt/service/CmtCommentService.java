package com.example.demo.cmt.service;

import com.example.demo.cmt.converter.CmtCommentConverter;
import com.example.demo.cmt.dao.CmtCommentDao;
import com.example.demo.cmt.dto.CmtCommentDto;
import com.example.demo.cmt.dto.CmtCustomerCommentsDto;
import com.example.demo.cmt.dto.CmtProductsCommentDto;
import com.example.demo.cmt.entity.CmtComment;
import com.example.demo.cus.dto.CusCustomerDto;
import com.example.demo.cus.entity.CusCustomer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CmtCommentService {
    private final CmtCommentEntityService cmtCommentEntityService;
    private final CmtCommentConverter cmtCommentConverter;

   public List<CmtCustomerCommentsDto> findCustomerComments(Long id){

       List<CmtComment> cmtCommentList =cmtCommentEntityService.findAllByCustomerId(id);

       List<CmtCustomerCommentsDto> cmtCommentDtoList = cmtCommentConverter.convertToCmtCustomerCommentsDtoList(cmtCommentList);

       return cmtCommentDtoList;
   }


    public List<CmtProductsCommentDto> findProductComments(Long id){

        List<CmtComment> cmtCommentList =cmtCommentEntityService.findAllByProductId(id);

        List<CmtProductsCommentDto> cmtCommentDtoList = cmtCommentConverter.convertToCmtProductsCommentDtoList(cmtCommentList);

        return cmtCommentDtoList;
    }


}
