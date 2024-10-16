package com.admin.nesreading.domain;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String title;
  private String publisher;
  private int publicationYear;
  private String shortDescription;
  private String detailDescription;
  private double price;
  private long sold;
  private long stock;
  private String image;

  @CreationTimestamp
  private LocalDateTime createAt;

  @UpdateTimestamp
  private LocalDateTime updateAt;

  @OneToMany(mappedBy = "book")
  private List<BookReview> bookReviews;

  @ManyToOne()
  @JoinColumn(name = "book_category_id")
  private BookCategory bookCategory;

  @OneToMany(mappedBy = "book")
  private List<Author> authors;

  @OneToMany(mappedBy = "book")
  private List<CartDetail> cartDetails;

  @OneToMany(mappedBy = "book")
  private List<OrderDetail> orderDetails;
}
