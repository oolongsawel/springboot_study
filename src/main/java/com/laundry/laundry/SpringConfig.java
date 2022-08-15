package com.laundry.laundry;

import com.laundry.laundry.repository.MemberRepository;
import com.laundry.laundry.repository.SpringDataJpaMemberRepository;
import com.laundry.laundry.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final SpringDataJpaMemberRepository memberRepository;

    public SpringConfig(SpringDataJpaMemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }
}
