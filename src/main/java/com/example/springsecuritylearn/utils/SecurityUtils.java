package com.example.springsecuritylearn.utils;

import com.example.springsecuritylearn.entities.Authority;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class SecurityUtils {

    private SecurityUtils() throws IllegalAccessException {
        throw new IllegalAccessException("C'est une classe utilitaire");
    }

    public static List<GrantedAuthority> getGrantedAuthorities(Set<Authority> authorities) {
        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        for (Authority authority : authorities) {
            grantedAuthorities.add(new SimpleGrantedAuthority(authority.getName()));
        }
        return grantedAuthorities;
    }
}
