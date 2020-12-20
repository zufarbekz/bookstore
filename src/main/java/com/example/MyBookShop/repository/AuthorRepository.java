package com.example.MyBookShop.repository;

import com.example.MyBookShop.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Integer> {
}

