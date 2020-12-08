package com.example.MyBookShop.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class BookService {

    private BookRepository bookRepository;

    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public List<Book> getBooks(){
        return bookRepository.findAll();
    }

    //using JDBC
    /*
    private JdbcTemplate jdbc;

    @Autowired
    public BookService(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public List<Book> getBooks() {
        List<Book> books = jdbc.query("SELECT * FROM books",
                                          (ResultSet rs, int rowNum) ->{
            Book book = new Book();
            book.setId(rs.getInt("id"));
            book.setAuthor(getAuthorByAuthorId(rs.getInt("author_id")));
            book.setTitle(rs.getString("title"));
            book.setPriceOld(rs.getString("price_old"));
            book.setPrice(rs.getString("price"));
            return book;
        });
        return new ArrayList<>(books);
    }

    private String getAuthorByAuthorId(int author_id){
        List<Author> authors = jdbc.query("SELECT * FROM authors WHERE authors.id=" + author_id,
                (ResultSet rs, int rowNum)->{
                    Author author = new Author();
                    author.setId(rs.getInt("id"));
                    author.setFirstName(rs.getString("first_name"));
                    author.setLastName(rs.getString("last_name"));
                    return author;
        });
        return authors.get(0).toString();
    }
    */
}
