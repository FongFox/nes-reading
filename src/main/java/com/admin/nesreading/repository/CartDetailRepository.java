package com.admin.nesreading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.nesreading.domain.CartDetail;

public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {

}
