package com.nesreading.domain;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
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

  // @OneToMany(mappedBy = "author")
  // private List<BookAuthor> bookAuthors;

  @ManyToMany(mappedBy = "authors")
  private List<Book> books = new ArrayList<>();

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getShortDescription() {
    return shortDescription;
  }

  public void setShortDescription(String shortDescription) {
    this.shortDescription = shortDescription;
  }

  public LocalDateTime getCreateAt() {
    return createAt;
  }

  public void setCreateAt(LocalDateTime createAt) {
    this.createAt = createAt;
  }

  public LocalDateTime getUpdateAt() {
    return updateAt;
  }

  public void setUpdateAt(LocalDateTime updateAt) {
    this.updateAt = updateAt;
  }

  public List<Book> getBooks() {
    return books;
  }

  public void setBooks(List<Book> books) {
    this.books = books;
  }

  @Override
  public String toString() {
    return "Author{" +
            "id=" + id +
            ", fullName='" + fullName + '\'' +
            ", shortDescription='" + shortDescription + '\'' +
            ", createAt=" + createAt +
            ", updateAt=" + updateAt +
            ", books=" + books +
            '}';
  }
}