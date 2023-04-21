package com.educandoweb.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.educandoweb.demo.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
