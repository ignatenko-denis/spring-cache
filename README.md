# spring-cache

Sample with Spring Cache (**@EnableCaching, @Cacheable, @CachePut, @CacheEvict**)

Console output
```console
15:52:21.155 [main] INFO  com.sample.TestRunner - call without cache (SAVE in cache)
15:52:21.187 [main] INFO  com.sample.service.BookService - getByIsbn(isbn-1, 1) ============>>>
15:52:21.202 [main] INFO  com.sample.service.BookService - reading data from DB...
15:52:31.214 [main] INFO  com.sample.TestRunner - [Book(isbn=isbn-1, title=1)]
15:52:31.214 [main] INFO  com.sample.TestRunner - 
15:52:31.214 [main] INFO  com.sample.TestRunner - call without cache (SAVE in cache)
15:52:31.214 [main] INFO  com.sample.service.BookService - getByIsbn(isbn-2, 2) ============>>>
15:52:31.214 [main] INFO  com.sample.service.BookService - reading data from DB...
15:52:41.218 [main] INFO  com.sample.TestRunner - [Book(isbn=isbn-2, title=2)]
15:52:41.218 [main] INFO  com.sample.TestRunner - 
15:52:41.218 [main] INFO  com.sample.TestRunner - return from cache OLD result
15:52:41.218 [main] INFO  com.sample.TestRunner - [Book(isbn=isbn-1, title=1)]
15:52:41.218 [main] INFO  com.sample.TestRunner - 
15:52:41.218 [main] INFO  com.sample.TestRunner - return from cache OLD result
15:52:41.218 [main] INFO  com.sample.TestRunner - [Book(isbn=isbn-2, title=2)]
15:52:41.218 [main] INFO  com.sample.TestRunner - 
15:52:41.218 [main] INFO  com.sample.TestRunner - put in cache NEW result
15:52:41.218 [main] INFO  com.sample.service.BookService - cachePut(isbn-1, 1) ============>>>
15:52:41.218 [main] INFO  com.sample.service.BookService - reading data from DB...
15:52:51.234 [main] INFO  com.sample.TestRunner - [Book(isbn=isbn-1, title=1)]
15:52:51.234 [main] INFO  com.sample.TestRunner - 
15:52:51.234 [main] INFO  com.sample.TestRunner - return from cache NEW result
15:52:51.234 [main] INFO  com.sample.TestRunner - [Book(isbn=isbn-1, title=1)]
15:52:51.234 [main] INFO  com.sample.TestRunner - 
15:52:51.234 [main] INFO  com.sample.service.BookService - cacheEvict()
15:52:51.234 [main] INFO  com.sample.TestRunner - 
15:52:51.234 [main] INFO  com.sample.TestRunner - put in cache the NEWEST result again
15:52:51.234 [main] INFO  com.sample.service.BookService - cachePut(isbn-1, 1) ============>>>
15:52:51.234 [main] INFO  com.sample.service.BookService - reading data from DB...
15:53:01.249 [main] INFO  com.sample.TestRunner - [Book(isbn=isbn-1, title=1)]
```