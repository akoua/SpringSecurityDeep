package com.example.springsecuritylearn.controller;

import com.example.springsecuritylearn.entities.NoticeDetail;
import com.example.springsecuritylearn.repository.NoticeDetailRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.CacheControl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping(path = "v1/api/notices")
@AllArgsConstructor
public class NoticesController {

    private NoticeDetailRepository noticeRepository;

    @GetMapping
    public ResponseEntity<List<NoticeDetail>> getNotices() {
        List<NoticeDetail> notices = noticeRepository.findAll();
        if (!notices.isEmpty()) {
            return ResponseEntity.ok()
                    .cacheControl(CacheControl.maxAge(60, TimeUnit.SECONDS))
                    .body(notices);
        } else {
            return null;
        }
    }
}
