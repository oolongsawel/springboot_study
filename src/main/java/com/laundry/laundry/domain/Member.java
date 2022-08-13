package com.laundry.laundry.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
@Table(name="member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//PK명시 , id값은 자동으로 +1 하는값
    private Long id;

    @Column(name= "name")
    private String name; //이름

    @Column(name = "mobilePhoneNumber")
    private String mobilePhoneNumber; //핸드폰 전화

    @Column(name = "homePhoneNumber")
    private String homePhoneNumber; //집전화

    @Column(name = "memo")
    private String memo; //메모

    @Column(name = "joinDate")
    private String joinDate; //가입 날짜

    @Column(name = "delDate")
    private String delDate; //고객 삭제 날짜

    @Column(name = "delYn")
    private boolean delYn; //삭제 여부

}
