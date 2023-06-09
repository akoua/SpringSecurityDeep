package com.example.springsecuritylearn.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "v1/api/cards")
public class CardsController {
    @GetMapping(value = "myCard")
    public ResponseEntity<String> getCardDetails(){
        return ResponseEntity.ok("Your card");
    }
}
