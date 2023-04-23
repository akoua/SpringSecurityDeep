package com.example.springsecuritylearn.entities;

import com.example.springsecuritylearn.enums.Role;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

@Entity
@Getter
@Setter
@With
@NoArgsConstructor
@AllArgsConstructor
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "increment")
    private Long id;
    private String number;
    private String pwd;
    @Enumerated
    private Role role;
}
