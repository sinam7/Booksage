package com.sinam7.booksage.service.user;

import com.sinam7.booksage.domain.account.Account;
import com.sinam7.booksage.domain.account.AccountDto;
import com.sinam7.booksage.exception.InvalidLoginException;
import com.sinam7.booksage.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;

    public Long createUser(AccountDto accountDto) {
        Account account = Account.build(accountDto);
        Account save = accountRepository.save(account);

        return save.getId();
    }

    public Optional<Account> findUser(Long userId) {
        return accountRepository.findById(userId);
    }

    public Long login(AccountDto accountDto) {
        Optional<Account> findUser =
                accountRepository.findByUsernameAndPassword(accountDto.username(), accountDto.password());

        if (findUser.isEmpty()) {
            throw new InvalidLoginException("Invalid login credentials");
        }

        return findUser.get().getId();
    }
}
