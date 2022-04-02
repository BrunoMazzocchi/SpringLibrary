package com.example.library.LibraryAPI.domain.service;
import com.example.library.LibraryAPI.persistence.entity.*;
import org.springframework.beans.factory.annotation.*;
import com.example.library.LibraryAPI.domain.repository.BorrowRepository;
import org.springframework.stereotype.*;
import java.util.*;

@Service
public class BorrowService {

    @Autowired
    private BorrowRepository borrowRepository;

    public List<Borrow> getAll(){
        return borrowRepository.getAll();
    }

    public Optional<List<Borrow>> getBorrowByStudentId(int studentId){
        return borrowRepository.getBorrowByStudentId(studentId);
    }

    public Optional<List<Borrow>> getBorrowByBookId(int bookId){
        return borrowRepository.getBorrowByBookId(bookId);
    }

    public Borrow save(Borrow borrow){
        return borrowRepository.save(borrow);
    }

}





