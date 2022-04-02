package com.example.library.LibraryAPI.web.config.controller;

import com.example.library.LibraryAPI.domain.service.*;
import com.example.library.LibraryAPI.persistence.entity.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/borrows")
public class BorrowController {

    @Autowired
    private BorrowService borrowService;

    @GetMapping("/all")
    public ResponseEntity<List<Borrow>> getAll(){
        return new ResponseEntity<>(borrowService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/student/{studentId}")
    public  ResponseEntity<List<Borrow>> getBorrowByStudentId(@PathVariable int studentId){
        return borrowService.getBorrowByStudentId(studentId).map(
                borrows -> new ResponseEntity<>(borrows, HttpStatus.OK)

        ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @GetMapping("/book/{bookId}")
    public  ResponseEntity<List<Borrow>> getBorrowByBookId(@PathVariable int bookId){
        return borrowService.getBorrowByBookId(bookId).map(
                borrows -> new ResponseEntity<>(borrows, HttpStatus.OK)

        ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    @PostMapping("/save")
    public ResponseEntity<Borrow> save(@RequestBody Borrow borrow){
        return new ResponseEntity<>(borrowService.save(borrow), HttpStatus.CREATED);
    }
}


