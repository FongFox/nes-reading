package com.nesreading.domain;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String fullname;
  private String email;
  private String phone;
  private String password;
  private String role;
  private String address;
  private String avatar;

  @CreationTimestamp
  private LocalDateTime createAt;

  @UpdateTimestamp
  private LocalDateTime updateAt;

  @OneToMany(mappedBy = "user")
  private List<Cart> carts;

  @OneToMany(mappedBy = "user")
  private List<BookReview> bookReviews;

  @OneToMany(mappedBy = "user")
  private List<Order> orders;
}
