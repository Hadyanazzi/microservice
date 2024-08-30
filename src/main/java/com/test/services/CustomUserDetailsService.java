package com.test.services;

import com.test.entities.User;
import com.test.repositories.UserRepository;
import com.test.shareddomain.constant.GlobalConstant;
import com.test.shareddomain.dto.response.BusinessFailedException;
import com.test.shareddomain.util.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository useRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = useRepository.findByUsername(username);
        if (user==null) {
            throw new BusinessFailedException(GlobalConstant.Key.USER, "global.messages.notfound", StatusCode.NOT_FOUND);
        }
        List<GrantedAuthority> authorities = Collections.singletonList(new SimpleGrantedAuthority(user.getRole()));
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), authorities);
    }
}