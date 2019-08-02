package com.example.demo.model;

import org.springframework.stereotype.Component;

/**
 * @author liuhy
 * @create 2019-08-01 17:37
 **/
@Component
public class Book {

    private int id;

    private String name;

    private String author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Book() {
    }

    public Book(int id, String name, String author) {
        this.id = id;
        this.name = name;
        this.author = author;
    }
}
