package com.example.MyBookShop.controllers;


import com.example.MyBookShop.data.Author;
import com.example.MyBookShop.data.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Map;

@Controller
public class AuthorsController {

    private final AuthorService authorService;

    @Autowired
    public AuthorsController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @ModelAttribute("authorsData")
    public Map<String, List<Author>> authorsMap(){
        return authorService.getAuthorsMap();
    }

    @GetMapping("/authors")
    public String getAuthorsPage(){
         return "authors/authors";
    }

    @GetMapping("/authors/slug")
    public String getSlugPage(){
        return "authors/slug";
    }

    @GetMapping("/books/author")
    public String getBooksAuthorPage(){
        return "books/author";
    }
}
