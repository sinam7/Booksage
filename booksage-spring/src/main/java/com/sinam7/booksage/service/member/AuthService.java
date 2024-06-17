package com.sinam7.booksage.service.member;

import com.sinam7.booksage.domain.member.Member;
import com.sinam7.booksage.repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository authRepository;

    public Member register(String memberId, String password) {
        Member member = new Member();
        member.setMemberId(memberId);
        member.setPassword(password);
        return authRepository.save(member);
    }

    public Member authenticate(String memberId, String password) {
        Optional<Member> member = authRepository.findByMemberId(memberId);
        if (member.isPresent() && member.get().getPassword().equals(password))
            return member.get();
        return null;
    }
}
