package com.example.MyBookShop.service;

import com.example.MyBookShop.model.Book;
import com.example.MyBookShop.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Page<Book> getPageOfRecommended(Integer offset, Integer limit){
        Pageable nextPage = PageRequest.of(offset,limit);
        return bookRepository.findAll(nextPage);
    }

    public List<Book> getBooksByAuthorName(String authorName){
        return bookRepository.findBookByAuthorFirstNameContaining(authorName);
    }

    public List<Book> getBooksByTitle(String title){
        return bookRepository.findBookByTitleContaining(title);
    }

    public List<Book> getBooksByPriceBetween(String min, String max){
        return bookRepository.findBookByPriceBetween(min,max);
    }

    public List<Book> getBooksByPrice(String price){
        return bookRepository.findBookByPriceContaining(price);
    }

    public List<Book> getBestsellers(){
        return bookRepository.getBestsellers();
    }

    public List<Book> getBooksByMaxDiscount(){
        return bookRepository.getBooksWithMaxDiscount();
    }

}
