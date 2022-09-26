package com.laundry.laundry.domain;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;


@NoArgsConstructor
@Data // @Getter , @Setter 와 동일함
@Entity //DB테이블과 같은것 DB상에 테이블명과 class명이 같다면 @Entity(name="member") 뒤에 생략가능
public class Orders {
    @Id //PK일 경우 다는 어노테이션
    @GeneratedValue(strategy = GenerationType.IDENTITY)//PK명시 , id값은 자동으로 +1 하는값
    private int orderId;

    private int memberId;

    private String memberName; //고객이름

    private String memo; //메모

    private int totalCount; //옷수량

    private int price; //가격

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderDate; //맡긴 날짜
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date pickUpDate; //찾은 날짜

    private boolean pickUpYn; //옷찾아간 여부

    @Builder
    public Orders(int memberId , String memberName , String memo, int totalCount
            , int price, Date orderDate, Date pickUpDate, boolean pickUpYn) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.memo = memo;
        this.totalCount = totalCount;
        this.price = price;
        this.orderDate = orderDate;
        this.pickUpDate = pickUpDate;
        this.pickUpYn = pickUpYn;
    }


}
