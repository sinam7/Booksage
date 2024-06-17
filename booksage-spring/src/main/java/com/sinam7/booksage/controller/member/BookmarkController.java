package com.sinam7.booksage.controller.member;


import com.sinam7.booksage.domain.member.Bookmark;
import com.sinam7.booksage.domain.member.Member;
import com.sinam7.booksage.service.member.AuthService;
import com.sinam7.booksage.service.member.BookmarkService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/member/bookmarks")
@RequiredArgsConstructor
public class BookmarkController {

    private final BookmarkService bookmarkService;
    private final AuthService authService;

    private Member authenticateRequest(String memberId, String password) {
        return authService.authenticate(memberId, password);
    }

    @PostMapping
    public ResponseEntity<String> addBookmark(@RequestParam String id,
                                              @RequestParam String password,
                                              @RequestBody Bookmark bookmark) {
        Member member = authenticateRequest(id, password);
        if (member == null) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
        bookmarkService.addBookmark(id, bookmark);
        return ResponseEntity.ok("Bookmark added successfully");
    }

    @DeleteMapping("/{bookmarkId}")
    public ResponseEntity<String> removeBookmark(@RequestParam String id,
                                                 @RequestParam String password,
                                                 @PathVariable Long bookmarkId) {
        Member member = authenticateRequest(id, password);
        if (member == null) {
            return ResponseEntity.status(401).body("Invalid credentials");
        }
        Long memberId = member.getId();
        bookmarkService.removeBookmark(memberId, bookmarkId);
        return ResponseEntity.ok("Bookmark removed successfully");
    }

    @GetMapping
    public ResponseEntity<List<Bookmark>> getBookmarks(@RequestParam String id,
                                                       @RequestParam String password) {
        Member member = authenticateRequest(id, password);
        if (member == null) {
            return ResponseEntity.status(401).body(null);
        }
        Long memberId = member.getId();
        return ResponseEntity.ok(bookmarkService.getBookmarks(memberId));
    }
}
