package com.nesreading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nesreading.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
