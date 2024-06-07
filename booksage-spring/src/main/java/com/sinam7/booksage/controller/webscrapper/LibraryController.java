package com.sinam7.booksage.controller.webscrapper;

import com.sinam7.booksage.domain.book.BookDTO;
import com.sinam7.booksage.service.webscrapper.LibraryScrapperService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/bookstore/library")
public class LibraryController {

    private final LibraryScrapperService libraryScrapperService;

    @GetMapping("/request-book")
    public ResponseEntity<?> redirectToRequestBook() {
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(URI.create("https://lib.kookmin.ac.kr/#/service/request-book"));
        return new ResponseEntity<>(headers, HttpStatus.MOVED_PERMANENTLY);
    }

    @GetMapping("/search")
    public List<BookDTO> search(@RequestParam("query") String query) {
        return (List<BookDTO>) libraryScrapperService.searchBook(query);
    }

    @GetMapping("")
    public List<BookDTO> findAll() {
        return (List<BookDTO>) libraryScrapperService.getBooks();
    }

}


