package com.laundry.laundry.repository;


import com.laundry.laundry.domain.Orders;

public interface OrdersRepository {
    Orders save(Orders orders);

}
