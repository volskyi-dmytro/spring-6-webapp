package com.stpunk.spring6webapp.repositories;

import com.stpunk.spring6webapp.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
