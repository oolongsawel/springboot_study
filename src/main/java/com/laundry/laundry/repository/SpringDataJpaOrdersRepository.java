package com.laundry.laundry.repository;

import com.laundry.laundry.domain.Orders;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJpaOrdersRepository extends JpaRepository<Orders, Long>, OrdersRepository {

}
