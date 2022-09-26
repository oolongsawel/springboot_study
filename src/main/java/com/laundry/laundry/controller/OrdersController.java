package com.laundry.laundry.controller;

import com.laundry.laundry.domain.Orders;
import com.laundry.laundry.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class OrdersController {
    private final OrdersService ordersService;

    @Autowired
    public OrdersController(OrdersService ordersService){
        this.ordersService = ordersService;
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
}
