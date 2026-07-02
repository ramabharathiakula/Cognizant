package com.library.service;

import com.library.repository.BookRepository;

public class BookService {

    private BookRepository bookRepository;

    public BookService() {
        System.out.println("Constructor: BookService bean created.");
    }

    public void setBookRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Initialization method
    public void init() {
        System.out.println("Init Method: Bean initialized.");
    }

    // Destroy method
    public void destroy() {
        System.out.println("Destroy Method: Bean destroyed.");
    }

    public void showBook() {
        System.out.println("Book Service is working...");
        bookRepository.displayBook();
    }
}