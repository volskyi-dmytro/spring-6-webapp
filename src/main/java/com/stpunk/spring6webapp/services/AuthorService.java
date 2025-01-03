package com.stpunk.spring6webapp.services;

import com.stpunk.spring6webapp.domain.Author;

public interface AuthorService {

    Iterable<Author> findAll();
}
