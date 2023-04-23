package com.example.springsecuritylearn.controller;

import com.example.springsecuritylearn.entities.Account;
import com.example.springsecuritylearn.repository.AccountRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "v1/api/account")
@AllArgsConstructor
public class AccountController {
    private AccountRepository accountRepository;

    @GetMapping("/myAccount")
    public Account getAccountDetails(@RequestParam String id) {
        return accountRepository.findByCustomer(id).orElseThrow();
    }
}
