package com.example.springsecuritylearn.security;

import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .requestMatchers("v1/api/account/*").authenticated() //Needing authentication before to access theses urls
                        .requestMatchers("v1/api/notices/**", "v1/api/contact/**").permitAll() //No authentication is needs
                        .and()
                                .formLogin()
                                        .and().httpBasic();

        return http.build();
    }

    @Bean
    public InMemoryUserDetailsManager createInMemoryUser(){
        var admin = User.withDefaultPasswordEncoder()
                .username("admin")
                .password("12345")
                .authorities("admin")
                .build();
        var user = User.withDefaultPasswordEncoder()
                .username("user")
                .password("12345")
                .authorities("user")
                .build();
        return new InMemoryUserDetailsManager(admin, user);
    }
}
