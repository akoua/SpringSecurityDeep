package com.example.springsecuritylearn.security;

import com.example.springsecuritylearn.security.filter.CsrfCookieFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
public class ProjectSecurityConfig {
    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http
//                .securityContext().requireExplicitSave(false)
//                .and().sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.ALWAYS))
//                .cors().configurationSource(request -> {
//                    CorsConfiguration config = new CorsConfiguration();
//                    config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
//                    config.setAllowedMethods(Collections.singletonList("*"));
//                    config.setAllowCredentials(true);
//                    config.setAllowedHeaders(Collections.singletonList("*"));
//                    config.setMaxAge(Duration.ofSeconds(3_600));
//                    return config;
//                })
//                .and()
                .csrf(csrf -> {
                    var requestHandler = new CsrfTokenRequestAttributeHandler();
                    requestHandler.setCsrfRequestAttributeName("_csrf");
                    csrf.csrfTokenRequestHandler(requestHandler)
                            .ignoringRequestMatchers(new AntPathRequestMatcher("/v1/api/contact/**"),
                                    new AntPathRequestMatcher("/v1/api/login/**"))
                            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
                })
                .addFilterAfter(new CsrfCookieFilter(), BasicAuthenticationFilter.class)
                .authorizeHttpRequests()
                .requestMatchers(new AntPathRequestMatcher("/v1/api/account/**"),
                        new AntPathRequestMatcher("/v1/api/balance/**"))
                .hasAnyRole("USER")
                .requestMatchers(
                        new AntPathRequestMatcher("/v1/api/login/user")
                ).authenticated() //Needing authentication before to access theses urls
                .and()
                .authorizeHttpRequests()
                .requestMatchers(new AntPathRequestMatcher("/v1/api/notices/**"),
                        new AntPathRequestMatcher("/v1/api/contact/**"),
                        new AntPathRequestMatcher("/v1/api/login/register")).permitAll() //No authentication is needs
                .and()
                .formLogin()
                .and().httpBasic();


        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
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
