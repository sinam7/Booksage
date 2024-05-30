package com.sinam7.booksage.controller;

import com.sinam7.booksage.domain.Book;
import com.sinam7.booksage.service.ScrapperService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;


@Slf4j
@RestController
@RequestMapping("/api/bookstore")
@RequiredArgsConstructor
public class BestSellerController {

    private final Map<String, ScrapperService> scrapperServiceMap;

    @PostConstruct
    public void postConstruct() {
        for (String key : scrapperServiceMap.keySet()) {
            log.info("key = {}, value = {}", key, scrapperServiceMap.get(key));
        }
    }

    @GetMapping("/{store}")
    public List<Book> findAll(@PathVariable("store") String key) {
        return (List<Book>) scrapperServiceMap.get(key + "ScrapperService").getBooks();
    }

    @GetMapping("/{store}/search")
    public List<Book> search(@PathVariable("store") String key, @RequestParam("query") String query) {
        return (List<Book>) scrapperServiceMap.get(key + "ScrapperService").searchBook(query);
    }







}
