package com.nesreading.domain;

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
@Table(name = "authors")
public class Author {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;

  private String fullName;
  private String shortDescription;

  @CreationTimestamp
  private LocalDateTime createAt;

  @UpdateTimestamp
  private LocalDateTime updateAt;

  @OneToMany(mappedBy = "author")
  private List<BookAuthor> bookAuthors;
}