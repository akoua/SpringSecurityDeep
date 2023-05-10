package com.example.springsecuritylearn.security;

import com.example.springsecuritylearn.security.filter.CsrfCookieFilter;
import com.example.springsecuritylearn.security.oauth.KeyCloakRoleConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;
import org.springframework.security.web.csrf.CookieCsrfTokenRepository;
import org.springframework.security.web.csrf.CsrfTokenRequestAttributeHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.cors.CorsConfiguration;

import java.time.Duration;
import java.util.Collections;

@Configuration
@EnableMethodSecurity(prePostEnabled = true)
public class ProjectSecurityConfig {

    @Bean
    SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {

        JwtAuthenticationConverter jwtAuthConverter = new JwtAuthenticationConverter();
        jwtAuthConverter.setJwtGrantedAuthoritiesConverter(new KeyCloakRoleConverter());

        http
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .cors().configurationSource(request -> {
                    CorsConfiguration config = new CorsConfiguration();
                    config.setAllowedOrigins(Collections.singletonList("http://localhost:4200"));
                    config.setAllowedMethods(Collections.singletonList("*"));
                    config.setAllowCredentials(true);
                    config.setAllowedHeaders(Collections.singletonList("*"));
                    config.setMaxAge(Duration.ofSeconds(3_600));
                    return config;
                })
                .and()
                .csrf(csrf -> {
                    var requestHandler = new CsrfTokenRequestAttributeHandler();
                    requestHandler.setCsrfRequestAttributeName("_csrf");
                    csrf.csrfTokenRequestHandler(requestHandler)
                            .ignoringRequestMatchers(new AntPathRequestMatcher("/v1/api/contact/**"),
                                    new AntPathRequestMatcher("/v1/api/login/**"))
                            .csrfTokenRepository(CookieCsrfTokenRepository.withHttpOnlyFalse());
                })
//                .addFilterBefore(new BusinessLogicFilter(), UsernamePasswordAuthenticationFilter.class)
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
                .oauth2ResourceServer().jwt().jwtAuthenticationConverter(jwtAuthConverter);

        return http.build();
    }

//    public JwtDecoder jwtDecoder(){
//        return new JwtDecode
//    }
    /*@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }*/
}
