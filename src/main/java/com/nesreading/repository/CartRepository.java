package com.nesreading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nesreading.domain.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
