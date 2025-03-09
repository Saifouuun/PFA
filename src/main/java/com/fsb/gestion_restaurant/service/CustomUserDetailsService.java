package com.fsb.gestion_restaurant.service;

import java.util.Collections;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


public class CustomUserDetailsService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        // For demonstration purposes, a hardcoded user is returned
        if ("helmi".equals(username)) {
            return new User(2,"helmi@gmail.com","1234","21212121","helmi2");
        }
        throw new UsernameNotFoundException("User not found");
    }
}

