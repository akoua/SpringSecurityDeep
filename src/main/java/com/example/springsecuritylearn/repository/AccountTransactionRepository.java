package com.example.springsecuritylearn.repository;

import com.example.springsecuritylearn.entities.AccountTransaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccountTransactionRepository extends JpaRepository<AccountTransaction, Long> {

    List<AccountTransaction> findAccountTransactionByCustomerIdOrderByTransactionDateDesc(String id);
}
