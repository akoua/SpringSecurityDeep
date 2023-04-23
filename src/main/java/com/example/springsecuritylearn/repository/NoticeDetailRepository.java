package com.example.springsecuritylearn.repository;

import com.example.springsecuritylearn.entities.NoticeDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticeDetailRepository extends JpaRepository<NoticeDetail, Long> {
}
