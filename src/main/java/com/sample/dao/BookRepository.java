package com.sample.dao;

import com.sample.dto.Book;

import java.util.List;

// WARNING: For real repository should be used annotation @org.springframework.stereotype.Repository
public interface BookRepository {
    List<Book> getByIsbn(String isbn, String code);
}
