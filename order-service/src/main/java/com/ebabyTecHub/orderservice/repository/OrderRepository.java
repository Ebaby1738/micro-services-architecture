package com.ebabyTecHub.orderservice.repository;

import com.ebabyTecHub.orderservice.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
