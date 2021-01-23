package com.example.MyBookShop.controllers;

import com.example.MyBookShop.model.Book;
import com.example.MyBookShop.model.RecommendedBooksPageDto;
import com.example.MyBookShop.service.BookService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.print.Pageable;
import java.util.List;

@Controller
public class MainPageController {

    private final BookService bookService;

    @Autowired
    public MainPageController(BookService bookService) {
        this.bookService = bookService;
    }

    @ModelAttribute("recommendedBooks")
    public List<Book> recommendedBooks(){
        return bookService.getPageOfRecommended(0,6).getContent();
    }

    @GetMapping("/")
    public String getMainPage(){
        return "index";
    }

    @GetMapping("/books/recommended")
    @ResponseBody
    public RecommendedBooksPageDto getRecommendedBooks(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit){
        return new RecommendedBooksPageDto(bookService.getPageOfRecommended(offset, limit).getContent());
    }

    @GetMapping("/popular")
    public String getPopularPage(){
        return "books/popular";
    }

    @GetMapping("/recent")
    public String getRecentPage(){
        return "books/recent";
    }

    @GetMapping("/postponed")
    public String getPostponedPage(){
        return "postponed";
    }

    @GetMapping("/signin")
    public String getSigninPage(){
        return "signin";
    }

    @GetMapping("/signup")
    public String getSignupPage(){
        return "signup";
    }

    @GetMapping("/cart")
    public String getCartPage(){
        return "cart";
    }

    @GetMapping("/about")
    public String getAboutPage(){
        return "about";
    }

    @GetMapping("/contacts")
    public String getContactsPage(){
        return "contacts";
    }

    @GetMapping("/faq")
    public String getFAQPage(){
        return "faq";
    }

    @GetMapping("/books/slug")
    public String getSlugPage(){
        return "books/slug";
    }

    @GetMapping("/tags")
    public String getTagsPage(){
        return "tags/index";
    }

    @GetMapping("/search")
    public String getSearchPage(){
        return "search/index";
    }
}
