package com.sinam7.booksage.controller.user;

import com.sinam7.booksage.domain.book.Book;
import com.sinam7.booksage.domain.book.BookDTO;
import com.sinam7.booksage.service.user.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/bookmark/")
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService;

    @GetMapping("")
    public List<Book> getBookmarks(@CookieValue(value = "userId") Long userId) {
        return bookmarkService.getBookmarks(userId);
    }

    @PostMapping("/add")
    public Long addBookmark(@CookieValue(value = "userId") Long userId, @RequestBody BookDTO book) {
        return bookmarkService.addBookmark(userId, book);
    }

    @DeleteMapping("/remove/{index}")
    public void removeBookmark(@CookieValue(value = "userId") Long userId, @PathVariable("index") Long bookId) {
        bookmarkService.removeBookmark(userId, bookId);
    }
}
