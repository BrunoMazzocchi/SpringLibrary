package com.example.library.LibraryAPI.persistence.crud;

import com.example.library.LibraryAPI.persistence.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.*;

import java.util.*;

public interface BookCrudRepository extends CrudRepository<Book, Integer> {
}
