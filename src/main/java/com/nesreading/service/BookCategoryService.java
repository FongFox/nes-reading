package com.nesreading.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nesreading.domain.Book;
import com.nesreading.domain.BookCategory;
import com.nesreading.repository.BookCategoryRepository;

@Service
public class BookCategoryService {
    private final BookCategoryRepository bookCategoryRepository;

  public BookCategoryService(BookCategoryRepository bookCategoryRepository) {
      this.bookCategoryRepository = bookCategoryRepository;
    }

  public List<BookCategory> handleFetchAllBookCategories() {
    return bookCategoryRepository.findAll();
  }

  public Optional<BookCategory> handleFetchBookCategoryById(long id) {
    return bookCategoryRepository.findById(id);
  }

  public BookCategory handleCreateBookCategory(BookCategory bookCategory) {
    return bookCategoryRepository.save(bookCategory);
  }

  public BookCategory handleUpdateBookCategory(BookCategory bookCategory) {
    BookCategory dbCategory = bookCategoryRepository.findById(bookCategory.getId()).get();

    dbCategory.setName(bookCategory.getName());
    dbCategory.setShortDescription(bookCategory.getShortDescription());

    return bookCategoryRepository.save(dbCategory);
  }

  public void handleDeleteBookCategory(long id) {
    bookCategoryRepository.deleteById(id);
  }
}
