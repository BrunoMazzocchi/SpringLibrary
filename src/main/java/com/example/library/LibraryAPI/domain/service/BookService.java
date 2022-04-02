package com.example.library.LibraryAPI.domain.service;

import com.example.library.LibraryAPI.domain.repository.*;
import com.example.library.LibraryAPI.persistence.entity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public List<Book> getAll(){
        return bookRepository.getAll();
    }

    public Optional<Book> getBook(int bookId){
        return bookRepository.getBook(bookId);
    }

    public Book save(Book book){
        return bookRepository.save(book);
    }

    public boolean delete(int bookId){
        return getBook(bookId).map(book -> {
            bookRepository.delete(bookId);
            return true;
        }).orElse(false);
        }

}
