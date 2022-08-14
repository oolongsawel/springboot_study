package com.laundry.laundry.controller;

import com.laundry.laundry.domain.Member;
import com.laundry.laundry.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

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
            System.out.println(member);
            memberService.join(member);
        } catch(Exception e) {
            message = e.getMessage();
        }
        message = memberForm.toString();
        model.addAttribute("message", message);

        return "hello";
    }

    //멤버조회
    @GetMapping("member/read")
    public String readMember(Model model){
        List<Member> memberList = memberService.ReadMemberList();
        model.addAttribute("memberList", memberList);
        return "member/read";
    }
}
