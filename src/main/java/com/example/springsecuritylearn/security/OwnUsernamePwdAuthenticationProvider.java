package com.example.springsecuritylearn.security;

import com.example.springsecuritylearn.entities.Customer;
import com.example.springsecuritylearn.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OwnUsernamePwdAuthenticationProvider implements AuthenticationProvider {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        String username = authentication.getName();
        List<Customer> customers = customerRepository.findCustomersByNumber(username);
        if (customers.size() > 1) {
            throw new AccountStatusException(String.format("Trop de compte associé au user %s", authentication.getName())) {
                @Override
                public String getMessage() {
                    return super.getMessage();
                }
            };
        } else if (customers.size() == 1) {
            String pwd = authentication.getCredentials().toString();
            List<GrantedAuthority> authorities = List.of(new SimpleGrantedAuthority(customers.get(0).getRole().name()));
            if (passwordEncoder.matches(pwd, customers.get(0).getPwd())) {
                return new UsernamePasswordAuthenticationToken(username, pwd, authorities);
            } else {
                throw new BadCredentialsException("InvalidPassword");
            }
        } else {
            throw new BadCredentialsException(String.format("Username %s not found", authentication.getName()));
        }
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return (UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication));
    }
}