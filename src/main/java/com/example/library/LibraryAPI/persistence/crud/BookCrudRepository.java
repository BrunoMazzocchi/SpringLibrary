package com.example.library.LibraryAPI.persistence.crud;

import com.example.library.LibraryAPI.persistence.entity.*;
import org.springframework.data.repository.*;


public interface BookCrudRepository extends CrudRepository<Book, Integer> {
}
