package com.admin.nesreading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.nesreading.domain.BookCategory;

public interface BookCategoryRepository extends JpaRepository<BookCategory, Long> {

}
