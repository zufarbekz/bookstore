package com.example.MyBookShop.controllers;

import com.example.MyBookShop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RecentBooksController {
    private final BookService bookService;

    @Autowired
    public RecentBooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/recent")
    public String getRecentPage(){
        return "books/recent";
    }

}
