package com.example.MyBookShop.model;

import javax.persistence.*;

@Entity
@Table(name = "book2user_type")
public class Book2UserType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String code;
    private Status name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Status getName() {
        return name;
    }

    public void setName(Status name) {
        this.name = name;
    }
}
