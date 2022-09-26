package com.laundry.laundry.service;

import com.laundry.laundry.domain.Orders;
import com.laundry.laundry.repository.OrdersRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public class OrdersService {
    private OrdersRepository ordersRepository;

    public OrdersService(OrdersRepository ordersRepository){
        this.ordersRepository = ordersRepository;
    }

    public int join(Orders orders){
        ordersRepository.save(orders);
        return orders.getOrderId();
    }
}
