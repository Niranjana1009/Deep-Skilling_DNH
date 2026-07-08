package com.example.librarylab;

import java.util.List;

public class LibraryService {
    private final BookRepository bookRepository;

    public LibraryService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public void addBook(String title) {
        bookRepository.save(title);
    }

    public List<String> getBooks() {
        return bookRepository.findAll();
    }
}
