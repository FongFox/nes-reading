package com.nesreading.service;

import com.nesreading.domain.Book;
import com.nesreading.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Book handleSaveBook(Book book) {
        Book tempBook = new Book();

        tempBook.setTitle(book.getTitle());
        tempBook.setPublisher(book.getPublisher());
        tempBook.setPublicationYear(book.getPublicationYear());
        tempBook.setShortDescription(book.getShortDescription());
        tempBook.setDetailDescription(book.getDetailDescription());
        tempBook.setPrice(book.getPrice());
        tempBook.setStock(book.getStock());

        return bookRepository.save(tempBook);
    }

    public List<Book> handleFetchAllBooks() {
        return bookRepository.findAll();
    }

    public Optional<Book> handleFetchBookById(long id) {
        return bookRepository.findById(id);
    }
}
