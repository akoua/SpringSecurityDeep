package com.example.springsecuritylearn.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "v1/api/notices")
public class NoticesController {
    @GetMapping
    public ResponseEntity<String> getDefaultNoticesDetails(){
        return ResponseEntity.ok("The notices");
    }
}
