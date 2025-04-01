package com.application.courselibrary.service;

import com.application.courselibrary.entity.Book;
import com.application.courselibrary.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {
    @Autowired
    private BookRepository bookRepository;

    public List<Book> findAllBooks() {
        return bookRepository.findAll();
    }

    public Book findBookById(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book NOT FOUND"));
        return book;
    }

    public void createBook(Book book) {
        bookRepository.save(book);
    }

    @Transactional
    public void updateBook(Book book) {
        Book existingBook = bookRepository.findById(book.getId())
                .orElseThrow(() -> new RuntimeException("Book NOT FOUND"));
        existingBook.setIsbn(book.getIsbn());
        existingBook.setName(book.getName());
        existingBook.setDescription(book.getDescription());
        existingBook.getAuthors().clear();
        existingBook.getAuthors().addAll(book.getAuthors());
        existingBook.getCategories().clear();
        existingBook.getCategories().addAll(book.getCategories());
        existingBook.getPublishers().clear();
        existingBook.getPublishers().addAll(book.getPublishers());
    }


    public void deleteBook(Long id) {
        Book book = bookRepository.findById(id).orElseThrow(() -> new RuntimeException("Book NOT FOUND"));
        bookRepository.deleteById(book.getId());

    }

}
