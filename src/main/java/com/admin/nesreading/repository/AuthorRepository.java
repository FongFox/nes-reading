package com.admin.nesreading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.nesreading.domain.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
