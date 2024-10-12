package com.admin.nesreading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.nesreading.domain.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
