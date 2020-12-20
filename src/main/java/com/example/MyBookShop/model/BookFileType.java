package com.example.MyBookShop.model;

import javax.persistence.*;

@Entity
@Table(name = "book_file_type")
public class BookFileType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private FileType name;
    private String text;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public FileType getName() {
        return name;
    }

    public void setName(FileType name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
