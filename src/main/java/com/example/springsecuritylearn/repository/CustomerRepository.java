package com.example.springsecuritylearn.repository;

import com.example.springsecuritylearn.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findCustomerByNumber(String number);

    List<Customer> findCustomersByNumber(String number);

    List<Customer> findCustomersByEmail(String email);
}
