package com.admin.nesreading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.nesreading.domain.Cart;

public interface CartRepository extends JpaRepository<Cart, Long> {

}
