package com.example.demo.domain.product.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

import java.util.Date;

@Getter
@ToString
@AllArgsConstructor
public class ProductReadResponse {

    private Long productId;
    private String title;
    private Integer price;
    private String detail;
    private Date regDate;
}
