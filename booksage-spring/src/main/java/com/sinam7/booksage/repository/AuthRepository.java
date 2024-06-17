package com.sinam7.booksage.repository;

import com.sinam7.booksage.domain.member.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface AuthRepository extends JpaRepository<Member, Long> {
    Optional<Member> findByMemberId(String memberId);
}
