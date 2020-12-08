package com.example.MyBookShop.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Integer> {

    List<Book> findBookByAuthor_FirstName(String name);

//    @Query("FROM books")
//    public List<Book> customGetBooks();

}