package com.admin.nesreading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.nesreading.domain.BookAuthor;

public interface BookAuthorRepository extends JpaRepository<BookAuthor, Long> {

}
