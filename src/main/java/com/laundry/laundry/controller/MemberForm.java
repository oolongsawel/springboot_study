package com.laundry.laundry.controller;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Column;
@Getter
@Setter
@ToString
public class MemberForm {
    private String name; //이름
    private String mobilePhoneNumber; //핸드폰 전화
    private String homePhoneNumber; //집전화
    private String memo; //메모

}
