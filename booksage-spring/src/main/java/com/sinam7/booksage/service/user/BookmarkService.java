package com.sinam7.booksage.service.user;

import com.sinam7.booksage.domain.account.Account;
import com.sinam7.booksage.domain.book.Book;
import com.sinam7.booksage.domain.book.BookDTO;
import com.sinam7.booksage.repository.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BookmarkService {

    private final AccountService accountService;
    private final BookmarkRepository bookmarkRepository;

    public List<Book> getBookmarks(Long userId) {
        return bookmarkRepository.findByBookmarkUserId(userId);
    }

    public Long addBookmark(Long userId, BookDTO bookDto) {
        Optional<Account> account = accountService.findUser(userId);
        if (account.isEmpty()) {
            return -1L;
        }
        Book book = Book.build(bookDto);
        book.setBookmarkUser(account.get());

        Book save = bookmarkRepository.save(book);
        return save.getId();
    }

    public void removeBookmark(Long userId, Long bookId) {
        Optional<Book> findBook = bookmarkRepository.findById(bookId);
        findBook.ifPresent(bookmarkRepository::delete);
    }
}
