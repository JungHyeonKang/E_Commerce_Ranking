package com.ecommerce.repository;

import com.ecommerce.domain.OrderList;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderListRepository extends JpaRepository<OrderList,Long> {
}
