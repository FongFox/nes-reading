package com.admin.nesreading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.nesreading.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
