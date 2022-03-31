package com.example.library.LibraryAPI.persistence.crud;

import com.example.library.LibraryAPI.persistence.entity.*;
import org.springframework.data.repository.*;

public interface BorrowCrudRepository extends CrudRepository<Borrow, Integer> {
}
