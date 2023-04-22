package com.example.springsecuritylearn.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .authorizeHttpRequests()
                .requestMatchers(new AntPathRequestMatcher("/v1/api/account/**")).authenticated() //Needing authentication before to access theses urls
                .and()
                .authorizeHttpRequests()
                .requestMatchers(new AntPathRequestMatcher("/v1/api/notices/**"),
                        new AntPathRequestMatcher("/v1/api/contact/**"),
                        new AntPathRequestMatcher("/v1/api/login/**")).permitAll() //No authentication is needs
                .and()
                .formLogin()
                .and().httpBasic();


        return http.build();
    }



    /*@Bean
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
    }*/
}
