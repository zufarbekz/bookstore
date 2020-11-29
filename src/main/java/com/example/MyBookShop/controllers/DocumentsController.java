package com.example.MyBookShop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DocumentsController {

    @GetMapping("/documents")
    public String getDocumentsPage(){
        return "documents/index";
    }

    @GetMapping("/documents/slug")
    public String getDocumentsSlugPage(){
        return "documents/slug";
    }
}
