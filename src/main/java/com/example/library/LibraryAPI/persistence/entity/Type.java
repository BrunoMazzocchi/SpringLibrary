package com.example.library.LibraryAPI.persistence.entity;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "types")
public class Type {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer typeId;
    private String name;

    @OneToMany(mappedBy = "type")
    private List<Book> books;
}
