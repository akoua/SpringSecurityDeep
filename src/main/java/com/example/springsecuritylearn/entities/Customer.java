package com.example.springsecuritylearn.entities;

import com.example.springsecuritylearn.enums.Role;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import lombok.*;

@Entity
@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(name = "id", column = @Column(name = "customer_id"))
public class Customer extends Auditable<String> {

    private String name;
    private String email;
    @Column(name = "mobile_number")
    private String number;
    private String pwd;
    @Enumerated
    private Role role;

}
