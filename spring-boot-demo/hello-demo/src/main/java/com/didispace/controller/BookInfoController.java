package com.didispace.controller;

import com.didispace.model.Book;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("bookInfo")
@Slf4j
public class BookInfoController {

    @Autowired
    private Book book;

    @RequestMapping("getBookName")
    public String getBookName() {
        return book.getName();
    }

    @RequestMapping("getBookAuthor")
    public String getBookAuthor() throws Exception {
        int sleepTime = new Random().nextInt(3000);
        log.info("sleepTime = {}" + sleepTime );
        Thread.sleep(sleepTime);
        return book.getAuthor();
    }
}
