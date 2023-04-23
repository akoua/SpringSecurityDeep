package com.example.springsecuritylearn.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "loan_id"))
public class Loan extends Auditable<String> {

    @Column(name = "start_dt")
    private Date startDt;

    @Column(name = "loan_type")
    private String loanType;

    @Column(name = "total_loan")
    private Double totalLoan;

    @Column(name = "amount_paid")
    private Double amountPaid;

    @Column(name = "outstanding_amount")
    private Double outstandingAmount;

    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.LAZY)
    private Customer customer;
}
