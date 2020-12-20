package com.example.MyBookShop.model;

import javax.persistence.*;

@Entity
@Table(name = "document")
public class Document {
     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;
     @Column(name = "sort_index")
     private Integer sortIndex;
     private String slug;
     private String title;
     private String text;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getSortIndex() {
        return sortIndex;
    }

    public void setSortIndex(Integer sortIndex) {
        this.sortIndex = sortIndex;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
