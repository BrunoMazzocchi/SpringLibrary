package com.example.library.LibraryAPI.persistence;

import com.example.library.LibraryAPI.persistence.crud.*;
import com.example.library.LibraryAPI.persistence.entity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.stereotype.*;

import java.security.*;
import java.util.*;

@EnableAutoConfiguration
@Repository
public class BorrowRepository implements  com.example.library.LibraryAPI.domain.repository.BorrowRepository {
    @Autowired
    private BorrowCrudRepository borrowCrudRepository;

    @Override
    public List<Borrow> getAll() {
        List<Borrow> borrows = (List<Borrow>) borrowCrudRepository.findAll();
        return borrows;
    }

    @Override
    public Optional<List<Borrow>>  getBorrowByStudentId(int studentId) {
        List<Borrow> borrows = borrowCrudRepository.findBorrowByStudentId(studentId);
        return Optional.of(borrows);

    }

    @Override
    public Optional<List<Borrow>> getBorrowByBookId(int bookId) {
        List<Borrow> borrows = borrowCrudRepository.findBorrowByBookId(bookId);
        return Optional.of(borrows);
    }
    @Override
    public Borrow save(Borrow borrow) {
        return borrowCrudRepository.save(borrow);
    }
}
