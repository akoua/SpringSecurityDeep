package com.example.springsecuritylearn.security.provider;

import com.example.springsecuritylearn.entities.Customer;
import com.example.springsecuritylearn.repository.CustomerRepository;
import com.example.springsecuritylearn.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AccountStatusException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class OwnNumberPwdAuthenticationProvider implements AuthenticationProvider {

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
            if (passwordEncoder.matches(pwd, customers.get(0).getPwd())) {
                return new UsernamePasswordAuthenticationToken(username, pwd, SecurityUtils.getGrantedAuthorities(customers.get(0).getAuthorities()));
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
