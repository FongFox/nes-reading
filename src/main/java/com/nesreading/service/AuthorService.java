package com.nesreading.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.nesreading.domain.Author;
import com.nesreading.repository.AuthorRepository;

@Service
public class AuthorService {
  private final AuthorRepository authorRepository;

  public AuthorService(AuthorRepository authorRepository) {
    this.authorRepository = authorRepository;
  }

  public List<Author> handleFetchAllAuthors() {
    return authorRepository.findAll();
  }

  public Optional<Author> handleFetchAuthorById(long id) {
    return authorRepository.findById(id);
  }

  public Author handleCreateUser(Author author) {
    return authorRepository.save(author);
  }

  public Author handleUpdateAuthor(Author author) {
    Author dbAuthor = authorRepository.findById(author.getId()).get();

    dbAuthor.setFullName(author.getFullName());
    dbAuthor.setShortDescription(author.getShortDescription());

    return authorRepository.save(dbAuthor);
  }

  public void handleDeleteAuthor(long id) {
    authorRepository.deleteById(id);
  }
}
