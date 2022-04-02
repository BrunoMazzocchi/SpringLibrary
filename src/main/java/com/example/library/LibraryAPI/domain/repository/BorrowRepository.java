package com.example.library.LibraryAPI.domain.repository;

import com.example.library.LibraryAPI.persistence.entity.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface BorrowRepository {
    List<Borrow> getAll();
    Optional<List<Borrow>> getBorrowByStudentId(int studentId);
    Optional<List<Borrow>>  getBorrowByBookId(int bookId);
    Borrow save (Borrow borrow);
}
