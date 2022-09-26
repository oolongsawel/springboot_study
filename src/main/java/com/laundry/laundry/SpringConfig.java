package com.laundry.laundry;

import com.laundry.laundry.repository.MemberRepository;
import com.laundry.laundry.repository.OrdersRepository;
import com.laundry.laundry.service.MemberService;
import com.laundry.laundry.service.OrdersService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    private final MemberRepository memberRepository;
    private final OrdersRepository ordersRepository;

    public SpringConfig(MemberRepository memberRepository, OrdersRepository ordersRepository){
        this.memberRepository = memberRepository;
        this.ordersRepository = ordersRepository;
    }
    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository);
    }

    @Bean
    public OrdersService ordersService(){
        return new OrdersService(ordersRepository);
    }

}
