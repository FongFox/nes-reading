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
  private int status; //0: in stock; 1: out of stock; 2: not available

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
  private List<BookAuthor> bookAuthors;

  @OneToMany(mappedBy = "book")
  private List<CartDetail> cartDetails;

  @OneToMany(mappedBy = "book")
  private List<OrderDetail> orderDetails;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getPublisher() {
    return publisher;
  }

  public void setPublisher(String publisher) {
    this.publisher = publisher;
  }

  public int getPublicationYear() {
    return publicationYear;
  }

  public void setPublicationYear(int publicationYear) {
    this.publicationYear = publicationYear;
  }

  public String getShortDescription() {
    return shortDescription;
  }

  public void setShortDescription(String shortDescription) {
    this.shortDescription = shortDescription;
  }

  public String getDetailDescription() {
    return detailDescription;
  }

  public void setDetailDescription(String detailDescription) {
    this.detailDescription = detailDescription;
  }

  public double getPrice() {
    return price;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public long getSold() {
    return sold;
  }

  public void setSold(long sold) {
    this.sold = sold;
  }

  public long getStock() {
    return stock;
  }

  public void setStock(long stock) {
    this.stock = stock;
  }

  public String getImage() {
    return image;
  }

  public void setImage(String image) {
    this.image = image;
  }

  public int getStatus() {
    return status;
  }

  public void setStatus(int status) {
    this.status = status;
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

  public List<BookReview> getBookReviews() {
    return bookReviews;
  }

  public void setBookReviews(List<BookReview> bookReviews) {
    this.bookReviews = bookReviews;
  }

  public BookCategory getBookCategory() {
    return bookCategory;
  }

  public void setBookCategory(BookCategory bookCategory) {
    this.bookCategory = bookCategory;
  }

  public List<BookAuthor> getBookAuthors() {
    return bookAuthors;
  }

  public void setBookAuthors(List<BookAuthor> bookAuthors) {
    this.bookAuthors = bookAuthors;
  }

  public List<CartDetail> getCartDetails() {
    return cartDetails;
  }

  public void setCartDetails(List<CartDetail> cartDetails) {
    this.cartDetails = cartDetails;
  }

  public List<OrderDetail> getOrderDetails() {
    return orderDetails;
  }

  public void setOrderDetails(List<OrderDetail> orderDetails) {
    this.orderDetails = orderDetails;
  }

  @Override
  public String toString() {
    return "Book [id=" + id + ", title=" + title + ", publisher=" + publisher + ", publicationYear=" + publicationYear
        + ", shortDescription=" + shortDescription + ", detailDescription=" + detailDescription + ", price=" + price
        + ", sold=" + sold + ", stock=" + stock + ", image=" + image + ", status=" + status + ", createAt=" + createAt
        + ", updateAt=" + updateAt + ", bookReviews=" + bookReviews + ", bookCategory=" + bookCategory
        + ", bookAuthors=" + bookAuthors + ", cartDetails=" + cartDetails + ", orderDetails=" + orderDetails + "]";
  }

}