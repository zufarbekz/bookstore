package com.example.MyBookShop.data;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class AuthorService {
    private final JdbcTemplate jdbc;

    @Autowired
    public AuthorService(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }

    public Map<String, List<Author>> getAuthorsMap() {
        List<Author> authors = jdbc.query("SELECT * FROM authors",
                (ResultSet rs, int rowNum) ->{
                    Author author = new Author();
                    author.setId(rs.getInt("id"));
                    author.setFirstName(rs.getString("first_name"));
                    author.setLastName(rs.getString("last_name"));
                    return author;
                });
        return authors.stream().collect(Collectors.groupingBy((Author o) -> {return o.getLastName().substring(0,1);}));
    }
}
