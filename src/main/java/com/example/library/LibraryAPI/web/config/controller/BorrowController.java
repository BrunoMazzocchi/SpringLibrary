package com.example.library.LibraryAPI.web.config.controller;

import com.example.library.LibraryAPI.domain.service.*;
import com.example.library.LibraryAPI.persistence.entity.*;
import io.swagger.annotations.*;
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
    @ApiOperation("Gets all the borrows registered")
    public ResponseEntity<List<Borrow>> getAll(){
        return new ResponseEntity<>(borrowService.getAll(), HttpStatus.OK);
    }

    @ApiOperation("Search a specifics borrow with a student ID")
    @GetMapping("/student/{studentId}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not found")
    })
    public  ResponseEntity<List<Borrow>> getBorrowByStudentId(@ApiParam(value = "Student's ID", required = true, example = "1")@PathVariable int studentId){
        return borrowService.getBorrowByStudentId(studentId).map(
                borrows -> new ResponseEntity<>(borrows, HttpStatus.OK)

        ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }


    @ApiOperation("Search a specifics borrow with a book ID")
    @GetMapping("/book/{bookId}")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not found")
    })
    public  ResponseEntity<List<Borrow>> getBorrowByBookId(@ApiParam(value = "Book's ID", required = true, example = "1")@PathVariable int bookId){
        return borrowService.getBorrowByBookId(bookId).map(
                borrows -> new ResponseEntity<>(borrows, HttpStatus.OK)

        ).orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @ApiOperation("Saves a borrow with the information required")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @PostMapping("/save")
    public ResponseEntity<Borrow> save(@ApiParam(value = "The book entity", required = true, example = "" +
            "{\n" +
            "  \"borrowId\": 0,\n" +
            "  \"studentId\": {\n" +
            "    \"bookId\": 0,\n" +
            "    \"takenDate\": \"string\",\n" +
            "    \"broughtDate\": 0\n" +
            "  }" +
            "")@RequestBody Borrow borrow){
        return new ResponseEntity<>(borrowService.save(borrow), HttpStatus.CREATED);
    }
}


