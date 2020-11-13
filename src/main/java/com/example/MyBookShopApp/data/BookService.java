package com.example.MyBookShopApp.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private JdbcTemplate jdbc;

    @Autowired
    public BookService(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Book> getBooks() {
        List<Book> books = jdbc.query("SELECT * FROM books", (ResultSet rs, int rowNum) ->{
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setAuthor(rs.getString("author"));
            book.setTitle(rs.getString("title"));
            book.setPriceOld(rs.getString("priceOld"));
            book.setPrice(rs.getString("price"));
            return book;
        });
        return new ArrayList<>(books);
    }

    public List<String> getAuthors() {
        List<String> authors = new ArrayList<>();
        for (Book book : getBooks()) {
            authors.add(book.getAuthor());
        }
        authors = authors.stream().sorted().collect(Collectors.toList());
        return authors;
    }

}
