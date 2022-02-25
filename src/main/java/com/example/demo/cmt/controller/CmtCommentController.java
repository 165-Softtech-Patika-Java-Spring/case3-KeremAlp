package com.example.demo.cmt.controller;

import com.example.demo.cmt.dto.CmtCommentDto;
import com.example.demo.cmt.dto.CmtCustomerCommentsDto;
import com.example.demo.cmt.dto.CmtProductsCommentDto;
import com.example.demo.cmt.entity.CmtComment;
import com.example.demo.cmt.service.CmtCommentService;
import com.example.demo.cus.dto.CusCustomerDto;
import com.example.demo.gen.dto.RestResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/comment")
@RequiredArgsConstructor
public class CmtCommentController {
    private final CmtCommentService cmtCommentService;
    @GetMapping("/customer/{id}")
    public ResponseEntity findByCustomer(@PathVariable Long id){

        List<CmtCustomerCommentsDto> cmtCommentDto = cmtCommentService.findCustomerComments(id);

        return ResponseEntity.ok(RestResponse.of(cmtCommentDto));
    }

    @GetMapping("/product/{id}")
    public ResponseEntity findByProduct(@PathVariable Long id){

        List<CmtProductsCommentDto> cmtCustomerCommentsDtoList = cmtCommentService.findProductComments(id);

        return ResponseEntity.ok(RestResponse.of(cmtCustomerCommentsDtoList));
    }
}
