package com.stpunk.spring6webapp.services;

import com.stpunk.spring6webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
