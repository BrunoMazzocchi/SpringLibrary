package com.example.library.LibraryAPI.persistence.entity;

import javax.persistence.*;
import java.sql.*;
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
    private Date takeDate;
    private Date broughtDate;


    @ManyToOne
    @JoinColumn(name = "bookId", insertable = false, updatable = false) //Mediante esto, no se actualizan ni
    private Book book;

    @OneToMany(mappedBy = "borrow")
    private List<Student> students;

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

    public Date getTakeDate() {
        return takeDate;
    }

    public void setTakeDate(Date takeDate) {
        this.takeDate = takeDate;
    }

    public Date getBroughtDate() {
        return broughtDate;
    }

    public void setBroughtDate(Date broughtDate) {
        this.broughtDate = broughtDate;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
