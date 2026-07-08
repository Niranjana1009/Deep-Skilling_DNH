package com.example.librarylab.service;

import com.example.librarylab.entity.BookEntity;
import com.example.librarylab.model.Book;
import com.example.librarylab.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getAllBooks() {
        return bookRepository.findAll().stream()
                .map(this::toModel)
                .collect(Collectors.toList());
    }

    private Book toModel(BookEntity entity) {
        return new Book(entity.getId(), entity.getTitle());
    }
}
