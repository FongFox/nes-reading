package com.nesreading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nesreading.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
