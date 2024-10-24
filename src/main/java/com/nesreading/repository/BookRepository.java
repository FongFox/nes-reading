package com.nesreading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nesreading.domain.Book;

public interface BookRepository extends JpaRepository<Book, Long> {

}
