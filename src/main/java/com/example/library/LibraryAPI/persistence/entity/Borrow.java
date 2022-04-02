package com.example.library.LibraryAPI.persistence.entity;

import javax.persistence.*;
import java.sql.Date;
import java.util.*;

@Entity
@Table(name = "borrows")
public class Borrow {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer borrowId;
    private Integer studentId;
    private Integer bookId;
    private Date takenDate;
    private Date broughtDate;


    public Integer getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(Integer borrowId) {
        this.borrowId = borrowId;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getBookId() {
        return bookId;
    }

    public void setBookId(Integer bookId) {
        this.bookId = bookId;
    }

    public Date getTakenDate() {
        return takenDate;
    }

    public void setTakenDate(Date takeDate) {
        this.takenDate = takeDate;
    }

    public Date getBroughtDate() {
        return broughtDate;
    }

    public void setBroughtDate(Date broughtDate) {
        this.broughtDate = broughtDate;
    }
}
