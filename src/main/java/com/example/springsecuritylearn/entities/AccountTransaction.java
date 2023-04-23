package com.example.springsecuritylearn.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Table(name = "account_transaction")
@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "transaction_id"))
public class AccountTransaction extends Auditable<String> {
    @Column(name = "transaction_date")
    private Date transactionDate = new Date();

    @Column(name = "transaction_summary")
    private String transactionSummary;

    @Column(name = "transaction_type")
    private String transactionType;
    @Column(name = "transaction_amt")
    private Double transactionAmt;

    @Column(name = "closing_balance")
    private Double closingBalance;

    @JoinColumn(name = "customer_id")
    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.LAZY)
    private Customer customer;

    @JoinColumn(name = "account_id")
    @ManyToOne(targetEntity = Account.class, fetch = FetchType.LAZY)
    private Account account_id;
}
