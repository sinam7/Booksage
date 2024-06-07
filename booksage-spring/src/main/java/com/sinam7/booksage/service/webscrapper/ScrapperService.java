package com.sinam7.booksage.service.webscrapper;

import com.sinam7.booksage.domain.book.BookDTO;
import lombok.RequiredArgsConstructor;

import java.time.Duration;
import java.util.List;

@RequiredArgsConstructor
public abstract class ScrapperService {

    protected static final Duration REQUEST_TIMEOUT = Duration.ofSeconds(10);

    public abstract List<? extends BookDTO> getBooks();
    public abstract List<? extends BookDTO> searchBook(String query);

}
