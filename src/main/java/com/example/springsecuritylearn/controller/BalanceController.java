package com.example.springsecuritylearn.controller;

import com.example.springsecuritylearn.entities.AccountTransaction;
import com.example.springsecuritylearn.repository.AccountTransactionRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "v1/api/balance")
@AllArgsConstructor
public class BalanceController {
    private AccountTransactionRepository accountTransactionsRepository;

    @GetMapping("/myBalance")
    public List<AccountTransaction> getBalanceDetails(@RequestParam String id) {
        List<AccountTransaction> accountTransactions = accountTransactionsRepository
                .findAccountTransactionByCustomerIdOrderByTransactionDateDesc(id);
        if (accountTransactions != null) {
            return accountTransactions;
        } else {
            return null;
        }
    }
}
