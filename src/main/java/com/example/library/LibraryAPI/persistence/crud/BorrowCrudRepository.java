package com.example.library.LibraryAPI.persistence.crud;

import com.example.library.LibraryAPI.persistence.entity.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.*;

import java.util.*;

public interface BorrowCrudRepository extends CrudRepository<Borrow, Integer> {

    @Query(value = "SELECT * FROM borrows WHERE student_id = ?", nativeQuery = true)
    List<Borrow > findBorrowByStudentId(int studentId);

    @Query(value = "SELECT * FROM borrows WHERE book_id = ?", nativeQuery = true)
    List<Borrow> findBorrowByBookId(int bookId);
}
