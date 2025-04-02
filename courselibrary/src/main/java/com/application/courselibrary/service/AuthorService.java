package com.application.courselibrary.service;

import com.application.courselibrary.entity.Author;
import com.application.courselibrary.mapper.AuthorMapper;
import com.application.courselibrary.repository.AuthorRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthorService {
    @Autowired
    private AuthorRepository authorRepository; // JPA Repository
    @Autowired
    private AuthorMapper authorMapper; // MyBatis Mapper

    public List<Author> findAllAuthors() {
//        return authorRepository.findAll();
        return authorMapper.findAll();
    }

    public Author findAuthorById(Long id) {
//        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
//        return author;
        return authorMapper.findById(id);
    }

    public void createAuthor(Author author) {
        authorRepository.save(author);
    }


    public void deleteAuthor(Long id) {
        Author author = authorRepository.findById(id).orElseThrow(() -> new RuntimeException("Author not found"));
        authorRepository.deleteById(author.getId());

    }

    @Transactional
    public void updateAuthor(Author author) {
        authorRepository.save(author);
    }
}
