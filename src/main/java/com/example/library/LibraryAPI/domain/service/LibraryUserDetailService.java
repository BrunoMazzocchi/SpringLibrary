package com.example.library.LibraryAPI.domain.service;

import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;

import java.util.*;
@Service
@Component
public class LibraryUserDetailService implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User("Test",  "{noop}Test", new ArrayList<>());
    }
}
