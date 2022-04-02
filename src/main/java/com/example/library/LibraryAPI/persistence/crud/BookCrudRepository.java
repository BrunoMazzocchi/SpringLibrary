package com.example.library.LibraryAPI.persistence.crud;

import com.example.library.LibraryAPI.persistence.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.*;

import java.util.*;


public interface BookCrudRepository extends CrudRepository<Book, Integer> {
    @Query(value = "SELECT dbo.books.book_id, dbo.books.name" +
            ", dbo.authors.name AS 'Author', dbo.authors.surname as 'Surname' FROM  dbo.books INNER JOIN   dbo.authors ON dbo.books.author_id = dbo.authors.author_id where authors.name = '?'", nativeQuery = true)
    List<Book> findBookByAuthorName(String name);



    @Query(value = "SELECT dbo.books.book_id, dbo.books.name, dbo.authors.name AS 'Author', dbo.authors.surname as 'Surname' FROM dbo.books INNER JOIN dbo.authors ON dbo.books.author_id = dbo.authors.author_id WHERE authors.surname = '?'", nativeQuery = true)
    List<Book> findBookByAuthorSurname(String surname);
    }