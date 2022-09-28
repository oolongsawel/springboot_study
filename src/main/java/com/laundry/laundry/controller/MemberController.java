package com.laundry.laundry.controller;

import com.laundry.laundry.domain.Member;
import com.laundry.laundry.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class MemberController {

    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("member/createMemberForm")
    public String createMemberForm(){
            return "member/createMemberForm";
    }

    @PostMapping("member/createMemberForm")
    public String createMember(MemberForm memberForm , Model model){
        String message = "";

        Member member = new Member();
        try {
            member.setName(memberForm.getName());
            member.setMobilePhoneNumber(memberForm.getMobilePhoneNumber());
            member.setHomePhoneNumber(memberForm.getHomePhoneNumber());
            member.setMemo(memberForm.getMemo());
            memberService.join(member);
        } catch(Exception e) {
            message = e.getMessage();
        }
        message = memberForm.toString();
        model.addAttribute("message", message);

        return "hello";
    }

    //전체멤버조회
    @GetMapping("member/read")
    public String readMember(Model model){
        //List<Member> memberList = memberService.ReadMemberList();
        List<Member> memberList = memberService.ReadMemberListByDelYn();

        model.addAttribute("memberList", memberList);
        return "member/read";
    }

    //멤버프로필 조회
    @GetMapping("/member/read/{id}")
    public String readMemberProfile(@PathVariable("id") int id, Model model){
        Optional<Member> member = memberService.getMemberProfile(id);
        if( member.isPresent() ) {
            model.addAttribute("member", member.get());
        }
        return "member/memberProfile.html";
    }

    //수정위한 멤버 폼
    @GetMapping("/member/updateMemberForm/{id}")
    public String updateMemberForm(@PathVariable("id") int id, Model model){
        Optional<Member> member = memberService.getMemberProfile(id);
        if( member.isPresent() ) {
            model.addAttribute("member", member.get());
        }
        return "member/updateMemberForm.html";
    }

    //멤버수정
    @PostMapping("member/updateMemberForm/{id}")
    public String updateMember(@PathVariable("id") int id, MemberForm memberForm , Model model){
        String name = memberForm.getName();
        String mobilePhoneNumber = memberForm.getMobilePhoneNumber();
        String homePhoneNumber = memberForm.getHomePhoneNumber();
        String memo = memberForm.getMemo();
        memberService.updateMember(id , name ,mobilePhoneNumber, homePhoneNumber, memo);

        return "hello";
    }

    //멤버삭제
    @GetMapping("member/delete/{id}")
    public String deleteMember(@PathVariable("id") int id , Model model){

        memberService.deleteMember(id);

        return "hello";
    }


}
