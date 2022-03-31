package com.example.library.LibraryAPI.domain.repository;

import com.example.library.LibraryAPI.persistence.entity.*;

import java.util.*;

public interface BookRepository {
    List<Book>getAll();
    Optional<List<Book>> getByType(int typeId);
    Optional<Book> getBook(int bookId);
     Book save (Book book);
     void delete(int bookId);
}
