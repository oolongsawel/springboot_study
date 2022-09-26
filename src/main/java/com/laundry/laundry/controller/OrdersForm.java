package com.laundry.laundry.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//주문폼
@Getter
@Setter
@ToString
public class OrdersForm {
    private String memberName; //고객이름
    private String memo; //메모
    private int totalCount; //건수
    private int price; //가격
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date  orderDate; //주문날짜
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pickUpDate; //찾은날짜
    private boolean pickUpYn; //찾은여부
}
