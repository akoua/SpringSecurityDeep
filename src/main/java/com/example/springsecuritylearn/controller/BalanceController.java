package com.example.springsecuritylearn.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "v1/api/balance")
public class BalanceController {
    @GetMapping(value = "myBalance")
    public ResponseEntity<String> getBalanceDetails(){
        return ResponseEntity.ok("Your balance");
    }
}
