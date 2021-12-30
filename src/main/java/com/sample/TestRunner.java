package com.sample;

import com.sample.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TestRunner implements CommandLineRunner {

    @Autowired
    private BookService bookService;

    @Override
    public void run(String... args) {
        log.info("");

        log.info("call without cache (SAVE in cache)");
        log.info("{}", bookService.getByIsbn("isbn-1", "1"));
        log.info("");

        log.info("call without cache (SAVE in cache)");
        log.info("{}", bookService.getByIsbn("isbn-2", "2"));
        log.info("");

        log.info("return from cache OLD result");
        log.info("{}", bookService.getByIsbn("isbn-1", "1"));
        log.info("");

        log.info("return from cache OLD result");
        log.info("{}", bookService.getByIsbn("isbn-2", "2"));
        log.info("");

        log.info("put in cache NEW result");
        log.info("{}", bookService.cachePut("isbn-1", "1"));
        log.info("");

        log.info("return from cache NEW result");
        log.info("{}", bookService.getByIsbn("isbn-1", "1"));
        log.info("");

        bookService.cacheEvict();
        log.info("");

        log.info("put in cache the NEWEST result again");
        log.info("{}", bookService.cachePut("isbn-1", "1"));
        log.info("");
    }
}
