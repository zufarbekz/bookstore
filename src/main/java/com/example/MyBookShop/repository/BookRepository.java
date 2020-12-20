package com.example.MyBookShop.repository;

import com.example.MyBookShop.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findBookByAuthor_FirstName(String name);
}
