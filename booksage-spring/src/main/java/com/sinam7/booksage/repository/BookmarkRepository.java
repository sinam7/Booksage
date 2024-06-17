package com.sinam7.booksage.repository;

import com.sinam7.booksage.domain.member.Bookmark;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
    List<Bookmark> findByMemberId(Long memberId);
}
