package com.example.springsecuritylearn.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "card_id"))
public class Card extends Auditable<String> {

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "card_type")
    private String cardType;

    @Column(name = "total_limit")
    private Double totalLimit;

    @Column(name = "amount_used")
    private Double amountUsed;

    @Column(name = "available_amount")
    private Double availableAmount;
    @JoinColumn(name = "customer_id")
    @ManyToOne(targetEntity = Customer.class, fetch = FetchType.LAZY)
    private Customer customer;
}
