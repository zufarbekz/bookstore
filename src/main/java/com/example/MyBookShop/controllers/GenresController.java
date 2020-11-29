package com.example.MyBookShop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GenresController {
    @GetMapping("/genres")
    public String getGenresPage(){
        return "genres/genres";
    }

    @GetMapping("/genres/slug")
    public String getGenresSlugPage(){
        return "genres/slug";
    }
}
