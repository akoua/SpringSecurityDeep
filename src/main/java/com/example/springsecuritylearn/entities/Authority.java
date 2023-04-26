package com.example.springsecuritylearn.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "authority_id"))
public class Authority extends Auditable<String> {
    private String name;
    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;
}
