package com.example.springsecuritylearn.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "v1/api/contact")
public class ContactController {

    @GetMapping(value = "allContacts")
    public ResponseEntity<String> getDefaultDetails(){
        return ResponseEntity.ok("The contacts");
    }
}
