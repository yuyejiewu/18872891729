package com.didispace.controller;

import com.didispace.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("bookInfo")
public class BookInfoController {

    @Autowired
    private Book book;

    @RequestMapping("getBookName")
    public String getBookName() {
        return book.getName();
    }

    @RequestMapping("getBookAuthor")
    public String getBookAuthor() {
        return book.getAuthor();
    }
}
