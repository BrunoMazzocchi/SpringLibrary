package com.example.library.LibraryAPI.domain.repository;

import com.example.library.LibraryAPI.persistence.entity.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface BookRepository {
    List<Book>getAll();
    Optional<Book> getBook(int bookId);
     Book save (Book book);
   Optional<List<Book > >findBookByAuthorName(String name);
   Optional<List<Book>> findBookByAuthorSurname(String surname);
    void delete(int bookId);
}
