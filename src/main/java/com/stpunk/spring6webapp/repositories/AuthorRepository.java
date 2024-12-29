package com.stpunk.spring6webapp.repositories;

import com.stpunk.spring6webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
