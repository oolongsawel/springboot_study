package com.laundry.laundry.service;

import com.laundry.laundry.domain.Member;
import com.laundry.laundry.repository.MemberRepository;
import com.laundry.laundry.repository.SpringDataJpaMemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Transactional
public class MemberService {

    private final MemberRepository memberRepository;
    public MemberService(MemberRepository memberRepository){
        this.memberRepository = memberRepository;
    }

    //회원가입
    public int join(Member member){

        //중복회원 검증햣
        //validateDuplicateMemberByName(member);
        //validateDuplicateMemberByPhoneNumber(member);
        memberRepository.save(member);
        return member.getId();
    }

    //중복확인
    private void validateDuplicateMemberByName(Member member){
        //같은 이름이 중복 회원X
        memberRepository.findByName(member.getName())
                .ifPresent(m-> {
                    throw new IllegalStateException("이미 존재하는 이름입니다");
                });
    }

    private void validateDuplicateMemberByPhoneNumber(Member member){
        //같은 이름이 중복 회원X
        memberRepository.findByMobilePhoneNumber(member.getMobilePhoneNumber())
                .ifPresent(m-> {
                    throw new IllegalStateException("이미 존재하는 핸드폰번호입니다");
                });
    }

    //전체멤버조회
    public List<Member> ReadMemberList(){
        return memberRepository.findAll();
    }


    //멤버프로필 조회
    public Optional<Member> getMemberProfile(int id){
        return memberRepository.findById(id);
    }

}
