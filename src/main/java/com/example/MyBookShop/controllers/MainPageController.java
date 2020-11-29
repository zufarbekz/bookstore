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
