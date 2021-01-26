package com.example.MyBookShop.controllers;

import com.example.MyBookShop.model.Book;
import com.example.MyBookShop.model.BooksPageDto;
import com.example.MyBookShop.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class RecentBooksController {
    private final BookService bookService;

    @Autowired
    public RecentBooksController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("filteredBooks")
    public List<Book> getFilteredBooks(){
        return new ArrayList<>();
    }

    @GetMapping("/recent")
    public String getRecentPage(){
        return "books/recent";
    }

    @GetMapping("/books/recent/date")
    @ResponseBody
    public BooksPageDto getFilteredBooksByDate(@RequestParam("offset") Integer offset,
                                               @RequestParam("limit") Integer limit,
                                               @RequestParam("from") String from,
                                               @RequestParam("to") String to){
        return new BooksPageDto(bookService.getPageOfFilteredBooks(offset,limit, from, to).getContent());
    }
}
