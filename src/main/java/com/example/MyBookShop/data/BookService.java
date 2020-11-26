package com.example.MyBookShop.data;

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
        List<Book> books = jdbc.query("SELECT * FROM books, authors WHERE books.id = authors.id",
                                          (ResultSet rs, int rowNum) ->{
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setAuthor(rs.getString("first_name") + " " + rs.getString("last_name"));
            book.setTitle(rs.getString("title"));
            book.setPriceOld(rs.getString("priceOld"));
            book.setPrice(rs.getString("price"));
            return book;
        });
        return new ArrayList<>(books);
    }
}
