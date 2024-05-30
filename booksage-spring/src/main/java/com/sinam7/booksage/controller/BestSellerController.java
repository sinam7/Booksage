package com.sinam7.booksage.controller;

import com.sinam7.booksage.domain.Book;
import com.sinam7.booksage.service.ScrapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/bookstore")
@RequiredArgsConstructor
public class BestSellerController {

    private final Map<String, ScrapperService> scrapperServiceMap;

    @GetMapping("/{store}")
    public List<Book> findAll(@PathVariable("store") String key) {
        return (List<Book>) scrapperServiceMap.get(key + "ScrapperService").getBooks();
    }

    @GetMapping("/{store}/search")
    public List<Book> search(@PathVariable("store") String key, @RequestParam("query") String query) {
        return (List<Book>) scrapperServiceMap.get(key + "ScrapperService").searchBook(query);
    }







}
