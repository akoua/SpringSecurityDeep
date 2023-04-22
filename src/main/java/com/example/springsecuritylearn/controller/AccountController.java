package com.example.springsecuritylearn.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "v1/api/account")
public class AccountController {
    @GetMapping(value = "myAccount")
    public ResponseEntity<String> getAccountDetails(){
        return ResponseEntity.ok("myAccount");
    }
}
