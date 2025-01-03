package com.stpunk.spring6webapp.bootstrap;

import com.stpunk.spring6webapp.domain.Author;
import com.stpunk.spring6webapp.domain.Book;
import com.stpunk.spring6webapp.domain.Publisher;
import com.stpunk.spring6webapp.repositories.AuthorRepository;
import com.stpunk.spring6webapp.repositories.BookRepository;
import com.stpunk.spring6webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // Create Authors
        Author author1 = new Author();
        author1.setFirstName("John");
        author1.setLastName("Doe");

        Book book1 = new Book();
        book1.setTitle("Spring in Action");
        book1.setIsbn("123-456");

        Author author1Saved = authorRepository.save(author1);
        Book book1Saved = bookRepository.save(book1);

        Author author2 = new Author();
        author2.setFirstName("Jane");
        author2.setLastName("Smith");

        Book book2 = new Book();
        book2.setTitle("Spring Boot Essentials");
        book2.setIsbn("789-101");

        Author author2Saved = authorRepository.save(author2);
        Book book2Saved = bookRepository.save(book2);

        author1Saved.getBooks().add(book1Saved);
        author2Saved.getBooks().add(book2Saved);
        book1Saved.getAuthors().add(author1Saved);
        book2Saved.getAuthors().add(author2Saved);

        Publisher publisher1 = new Publisher();
        publisher1.setPublisherName("Ababagalamaga");
        publisher1.setCity("Kyiv");
        publisher1.setState("Kyiv Oblast");
        publisher1.setAddress("Peremohy 1");
        publisher1.setZip("111222");

        Publisher savedPublisher = publisherRepository.save(publisher1);

        book1Saved.setPublisher(savedPublisher);
        book2Saved.setPublisher(savedPublisher);

        authorRepository.save(author1Saved);
        authorRepository.save(author2Saved);
        bookRepository.save(book1Saved);
        bookRepository.save(book2Saved);

        System.out.println("In Bootstrap");
        System.out.println("Author count: " + authorRepository.count());
        System.out.println("Book count: " + bookRepository.count());
        System.out.println("Publisher count: " + publisherRepository.count());
    }
}
