package com.example.MyBookShop.controllers;

import com.example.MyBookShop.model.Book;
import com.example.MyBookShop.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Api("Book Rest API")
@RequestMapping("/api")
public class BookRestApiController {
    private BookService bookService;

    @Autowired
    public BookRestApiController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books/by-author")
    @ApiOperation("List of books found by author's first name")
    public ResponseEntity<List<Book>> getBooksByAuthorName(@RequestParam("author") String authorName){
        return ResponseEntity.ok(bookService.getBooksByAuthorName(authorName));
    }

    @GetMapping("/books/by-title")
    @ApiOperation("List of books found by title")
    public ResponseEntity<List<Book>> getBooksByTitle(@RequestParam("title") String title){
        return ResponseEntity.ok(bookService.getBooksByTitle(title));
    }

    @GetMapping("/books/price-between")
    @ApiOperation("List of books in specific range of price")
    public ResponseEntity<List<Book>> getBooksByPriceBetween(@RequestParam("min") String min, @RequestParam("max") String max){
        return ResponseEntity.ok(bookService.getBooksByPriceBetween(min, max));
    }

    @GetMapping("/books/with-price")
    @ApiOperation("List of book with corresponding price")
    public ResponseEntity<List<Book>> getBooksWithPrice(@RequestParam("price") String price){
        return ResponseEntity.ok(bookService.getBooksByPrice(price));
    }

    @GetMapping("/books/bestsellers")
    @ApiOperation("List of bestsellers")
    public ResponseEntity<List<Book>> getBestsellers(){
        return ResponseEntity.ok(bookService.getBestsellers());
    }

    @GetMapping("/books/max-discount")
    @ApiOperation("Book with Max Discount")
    public ResponseEntity<List<Book>> getBooksWithMaxDiscount(){
        return ResponseEntity.ok(bookService.getBooksByMaxDiscount());
    }
}
