package com.nesreading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nesreading.domain.CartDetail;

public interface CartDetailRepository extends JpaRepository<CartDetail, Long> {

}
