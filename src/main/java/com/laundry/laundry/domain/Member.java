package com.laundry.laundry.domain;


import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@Data // @Getter , @Setter 와 동일함
@Entity //DB테이블과 같은것 DB상에 테이블명과 class명이 같다면 @Entity(name="member") 뒤에 생략가능
public class Member {

    @Id //PK일 경우 다는 어노테이션
    @GeneratedValue(strategy = GenerationType.IDENTITY)//PK명시 , id값은 자동으로 +1 하는값
    private int id;
    @Column(name="name") //필드가 컬럼일 경우 추가하는 어노테이션 , DB상의 컬럼 이름과 일치하면 생략가능
    private String name; //이름
    @Column(name="mobilePhoneNumber")

    private String mobilePhoneNumber; //핸드폰 전화

    private String homePhoneNumber; //집전화

    private String memo; //메모

    private String joinDate; //가입 날짜

    private String delDate; //고객 삭제 날짜

    private boolean delYn; //삭제 여부

    @Builder
    public Member(String name, String mobilePhoneNumber, String homePhoneNumber
            , String memo, String joinDate, String delDate, boolean delYn) {
        this.name = name;
        this.mobilePhoneNumber = mobilePhoneNumber;
        this.homePhoneNumber = homePhoneNumber;
        this.memo = memo;
        this.joinDate = joinDate;
        this.delDate = delDate;
        this.delYn = delYn;
    }

}
