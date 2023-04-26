package com.example.springsecuritylearn.entities;

import com.example.springsecuritylearn.enums.Role;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

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
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String pwd;
    @Enumerated
    private Role role;
    @JsonIgnore
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private Set<Authority> authorities;

}
