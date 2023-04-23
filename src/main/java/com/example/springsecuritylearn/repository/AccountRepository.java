package com.example.springsecuritylearn.repository;

import com.example.springsecuritylearn.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByCustomer(String id);

    Optional<Account> findAccountById(String id);
}
