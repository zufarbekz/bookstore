package com.example.MyBookShop.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "book2user")
public class Book2User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(columnDefinition = "DATE")
    private String time;

    @Column(name = "type_id")
    private Integer typeId;

//    @ManyToOne
//    @JoinColumn(name = "book_id", referencedColumnName = "id")
//    private Book book;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    private User user;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

}
