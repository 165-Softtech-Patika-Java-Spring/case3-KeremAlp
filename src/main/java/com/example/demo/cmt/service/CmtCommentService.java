package com.example.demo.cmt.service;

import com.example.demo.cmt.converter.CmtCommentConverter;
import com.example.demo.cmt.converter.CmtCommentMapper;
import com.example.demo.cmt.dao.CmtCommentDao;
import com.example.demo.cmt.dto.CmtCommentDto;
import com.example.demo.cmt.dto.CmtCustomerCommentsDto;
import com.example.demo.cmt.dto.CmtProductsCommentDto;
import com.example.demo.cmt.dto.CmtSaveRequestDto;
import com.example.demo.cmt.entity.CmtComment;
import com.example.demo.cus.converter.CusCustomerMapper;
import com.example.demo.cus.dto.CusCustomerDeleteRequestDto;
import com.example.demo.cus.dto.CusCustomerDto;
import com.example.demo.cus.entity.CusCustomer;
import com.example.demo.prd.converter.PrdProductMapper;
import com.example.demo.prd.dto.PrdProductDto;
import com.example.demo.prd.dto.PrdProductSaveRequestDto;
import com.example.demo.prd.entity.PrdProduct;
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

    public CmtCommentDto save(CmtSaveRequestDto cmtSaveRequestDto) {

        CmtComment cmtComment = CmtCommentMapper.INSTANCE.convertToComment(cmtSaveRequestDto);

        cmtComment = cmtCommentEntityService.save(cmtComment);

        CmtCommentDto cmtCommentDto = cmtCommentConverter.convertToCmtCommentDto(cmtComment);

        return cmtCommentDto;
    }

    public void delete(Long id) {

        CmtComment cmtComment = cmtCommentEntityService.findById(id).get();
        cmtCommentEntityService.delete(cmtComment);
    }

}
