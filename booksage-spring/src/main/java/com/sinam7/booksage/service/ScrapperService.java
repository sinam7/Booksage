package com.sinam7.booksage.service;

import com.sinam7.booksage.domain.Book;
import lombok.RequiredArgsConstructor;

import java.time.Duration;
import java.util.List;

@RequiredArgsConstructor
public abstract class ScrapperService {

    protected static final Duration REQUEST_TIMEOUT = Duration.ofSeconds(10);

    public abstract List<? extends Book> getBooks();
    public abstract List<? extends Book> searchBook(String query);

}
