package com.sinam7.booksage.controller.user;

import com.sinam7.booksage.domain.account.AccountDto;
import com.sinam7.booksage.exception.InvalidLoginException;
import com.sinam7.booksage.service.user.AccountService;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/account")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping("/register")
    public Long register(@RequestBody AccountDto accountDto) {
        return accountService.createUser(accountDto);
    }

    @PostMapping("/login")
    public Long login(@RequestBody AccountDto accountDto, HttpServletResponse response) throws IOException {
        try {
            Long userId = accountService.login(accountDto);
            response.addCookie(new Cookie("userId", userId.toString()));
            return userId;
        } catch (InvalidLoginException e) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "No account matches the given username and password.");
            return null;
        }
    }


}
