package com.sample.service;

import com.sample.dao.BookRepository;
import com.sample.dto.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.List;

@Slf4j
@Component
public class BookService implements BookRepository {
    private static final String BOOKS_CACHE_NAME = "BOOKS_CACHE_NAME";

    /**
     * Read data from cache.
     */
    @Override
    @Cacheable(BOOKS_CACHE_NAME)
    public List<Book> getByIsbn(String isbn, String title) {
        log.info("getByIsbn({}, {}) ============>>>", isbn, title);
        simulateSlowService();

        return Collections.singletonList(new Book(isbn, title));
    }

    /**
     * Update just one value in cache.
     */
    @CachePut(BOOKS_CACHE_NAME)
    public List<Book> cachePut(String isbn, String title) {
        log.info("cachePut({}, {}) ============>>>", isbn, title);
        simulateSlowService();

        return Collections.singletonList(new Book(isbn, title));
    }

    private void simulateSlowService() {
        log.info("reading data from DB...");
        try {
            Thread.sleep(10_000L);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
    }

    /**
     * Erase cache at all.
     */
    @CacheEvict(BOOKS_CACHE_NAME)
    public void cacheEvict() {
        log.info("cacheEvict()");
    }
}
