package com.nesreading.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.nesreading.domain.Book;
import com.nesreading.repository.BookRepository;
import com.nesreading.repository.CartDetailRepository;
import com.nesreading.repository.CartRepository;
import com.nesreading.repository.OrderDetailRepository;
import com.nesreading.repository.OrderRepository;

@Service
public class BookService {
     private final BookRepository bookRepository;
    private final CartRepository cartRepository;
    private final CartDetailRepository cartDetailsRepository;
    // private final UserService userService;
    private final OrderRepository orderRepository;
    private final OrderDetailRepository orderDetailRepository;

    public BookService(BookRepository bookRepository, CartRepository cartRepository, CartDetailRepository cartDetailsRepository, OrderRepository orderRepository, OrderDetailRepository orderDetailRepository) {
        this.bookRepository = bookRepository;
        this.cartRepository = cartRepository;
        this.cartDetailsRepository = cartDetailsRepository;
        this.orderRepository = orderRepository;
        this.orderDetailRepository = orderDetailRepository;
    }

    public Page<Book> handleFetchAllBooks(Pageable pageable){
        return this.bookRepository.findAll(pageable);
    }

    public Book handleFetchBookById(long id){
        return this.bookRepository.findById(id).get();
    }

    public Book handleSaveBook(Book book){
        return this.bookRepository.save(book);
    }

    public void handleDeleBook(long id){
        this.bookRepository.deleteById(id);
    }

    // public Page<Book> fetchBooksWithSpec(Pageable pageable, Book book){

    // }
}
