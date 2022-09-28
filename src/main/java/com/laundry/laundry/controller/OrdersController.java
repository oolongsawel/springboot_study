package com.laundry.laundry.controller;

import com.laundry.laundry.domain.Member;
import com.laundry.laundry.domain.Orders;
import com.laundry.laundry.service.MemberService;
import com.laundry.laundry.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.Optional;

@Controller
public class OrdersController {
    private final OrdersService ordersService;

    private final MemberService memberService;

    @Autowired
    public OrdersController(OrdersService ordersService, MemberService memberService){
        this.ordersService = ordersService;
        this.memberService = memberService;
    }

    @GetMapping("orders/createOrdersForm")
    public String createMemberForm(){
        return "orders/createOrdersForm";
    }

    @PostMapping("orders/createOrdersForm")
    public String createOrders(OrdersForm ordersForm , Model model){
        String message = "";

        Orders orders = new Orders();
        try {
            orders.setMemberName(ordersForm.getMemberName());
            orders.setMemo(ordersForm.getMemo());
            orders.setTotalCount(ordersForm.getTotalCount());
            orders.setPrice(ordersForm.getPrice());
            orders.setOrderDate(ordersForm.getOrderDate());
            orders.setPickUpDate(ordersForm.getPickUpDate());
            orders.setPickUpYn(ordersForm.isPickUpYn());
            ordersService.join(orders);
        } catch(Exception e) {

            message = e.getMessage();
        }

        message = ordersForm.toString();
        model.addAttribute("message", message);

        return "hello";
    }

    @GetMapping("orders/child")
    public String child(){
        return "orders/child";
    }

    //멤버검색
    @PostMapping("orders/child")
    public String searchMember(MemberForm memberForm , Model model){
        //memberForm.getName()
        List<Member> memberList = memberService.SearchMemberList(memberForm.getName());

        model.addAttribute("memberList", memberList);
        return "orders/child";
    }
}
