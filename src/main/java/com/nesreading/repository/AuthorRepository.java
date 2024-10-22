package com.nesreading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nesreading.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {
  
}
