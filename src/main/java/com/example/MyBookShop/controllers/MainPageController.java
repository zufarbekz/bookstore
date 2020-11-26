package com.example.MyBookShop.controllers;

import com.example.MyBookShop.data.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    private final BookService bookService;

    @Autowired
    public MainPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/")
    public String getMainPage(Model model){
        model.addAttribute("bookData", bookService.getBooks());
        return "index";
    }

    @GetMapping("/genres")
    public String getGenresPage(){
        return "genres/genres";
    }
}
