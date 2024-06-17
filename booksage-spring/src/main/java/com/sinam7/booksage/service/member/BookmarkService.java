package com.sinam7.booksage.service.member;

import com.sinam7.booksage.domain.member.Bookmark;
import com.sinam7.booksage.domain.member.Member;
import com.sinam7.booksage.repository.AuthRepository;
import com.sinam7.booksage.repository.BookmarkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookmarkService {


    private final BookmarkRepository bookmarkRepository;
    private final AuthRepository authRepository;

    public Bookmark addBookmark(String memberId, Bookmark bookmark) {
        Member member = authRepository.findByMemberId(memberId).orElseThrow();
        bookmark.setMember(member);
        return bookmarkRepository.save(bookmark);
    }

    public void removeBookmark(Long memberId, Long bookmarkId) {
        Bookmark bookmark = bookmarkRepository.findById(bookmarkId).orElseThrow();
        if (bookmark.getMember().getId().equals(memberId)) {
            bookmarkRepository.delete(bookmark);
        } else {
            throw new IllegalArgumentException("Bookmark does not belong to the member");
        }
    }

    public List<Bookmark> getBookmarks(Long memberId) {
        return bookmarkRepository.findByMemberId(memberId);
    }
}
