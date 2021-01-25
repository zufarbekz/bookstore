package com.example.MyBookShop.controllers;

import com.example.MyBookShop.model.Book;
import com.example.MyBookShop.model.BooksPageDto;
import com.example.MyBookShop.model.SearchWordDto;
import com.example.MyBookShop.service.BookService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainPageController {

    private final BookService bookService;

    @Autowired
    public MainPageController(BookService bookService) {
        this.bookService = bookService;
    }

    // Methods for initializing model attributes

    @ModelAttribute("recommendedBooks")
    public List<Book> recommendedBooks(){
        return bookService.getPageOfRecommended(0,6).getContent();
    }

    @ModelAttribute("recentBooks")
    public List<Book> recentBooks(){
        return bookService.getPageOfRecent(0,6).getContent();
    }

    @ModelAttribute("popularBooks")
    public List<Book> popularBooks(){
        return bookService.getPageOfPopular(0,6).getContent();
    }

    @ModelAttribute("searchWordDto")
    public SearchWordDto getSearchWordDto(){
        return new SearchWordDto();
    }

    @ModelAttribute("getSearchResults")
    public List<Book> getSearchResults(){
        return new ArrayList<>();
    }


    @GetMapping("/")
    public String getMainPage(){
        return "index";
    }

    @GetMapping("/popular")
    public String getPopularPage(){
        return "books/popular";
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



    @GetMapping("/books/recommended")
    @ResponseBody
    public BooksPageDto getRecommendedBooks(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit){
        return new BooksPageDto(bookService.getPageOfRecommended(offset, limit).getContent());
    }

    @GetMapping("/books/recent")
    @ResponseBody
    public BooksPageDto getRecentBooks(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit){
        return new BooksPageDto(bookService.getPageOfRecommended(offset, limit).getContent());
    }

    @GetMapping("books/popular")
    @ResponseBody
    public BooksPageDto getPopularBooks(@RequestParam("offset") Integer offset, @RequestParam("limit") Integer limit){
       return new BooksPageDto(bookService.getPageOfPopular(offset, limit).getContent());
    }

    @GetMapping("/search/page/{searchWord}")
    @ResponseBody
    public BooksPageDto getNextSearchPage(@PathVariable(value = "searchWord", required = false) SearchWordDto searchWordDto,
                                          @RequestParam("offset") Integer offset,
                                          @RequestParam("limit") Integer limit){

        return new BooksPageDto(bookService.getPageOfBookSearch(searchWordDto.getExample(),offset,limit).getContent());
    }

    @GetMapping(value = {"/search", "/search/{searchWord}"})
    public String getSearchPage(@PathVariable(value = "searchWord", required = false) SearchWordDto searchWordDto,
                                Model model){
        model.addAttribute("searchWordDto", searchWordDto);
        model.addAttribute("getSearchResults", bookService.getPageOfBookSearch(searchWordDto.getExample(), 0,5).getContent());
        return "/search/index";
    }
}
