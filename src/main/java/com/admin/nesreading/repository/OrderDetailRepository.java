package com.admin.nesreading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.nesreading.domain.OrderDetail;

public interface OrderDetailRepository extends JpaRepository<OrderDetail, Long> {

}
