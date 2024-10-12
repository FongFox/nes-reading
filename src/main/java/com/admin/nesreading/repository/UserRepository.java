package com.admin.nesreading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.nesreading.domain.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
