package com.admin.nesreading.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.nesreading.domain.BookReview;

public interface BookReviewRepository extends JpaRepository<BookReview, Long> {

}
