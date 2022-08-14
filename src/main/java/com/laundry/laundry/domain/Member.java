package com.laundry.laundry.domain;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//PK명시 , id값은 자동으로 +1 하는값
    private Long id;

    private String name; //이름

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
