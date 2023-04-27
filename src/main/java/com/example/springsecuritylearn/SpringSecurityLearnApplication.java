package com.example.springsecuritylearn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableWebSecurity(debug = true)
public class SpringSecurityLearnApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityLearnApplication.class, args);
    }

    //must do here, otherwise it will not injected in the correct time
    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
