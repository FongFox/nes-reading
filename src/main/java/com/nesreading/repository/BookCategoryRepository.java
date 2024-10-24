package com.nesreading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nesreading.domain.BookCategory;
public interface BookCategoryRepository extends JpaRepository<BookCategory, Long> {

}
