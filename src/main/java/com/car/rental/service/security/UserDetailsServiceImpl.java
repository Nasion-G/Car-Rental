package com.sda.springsecuritydemo.security;

import com.sda.springsecuritydemo.dao.UserEntity;
import com.sda.springsecuritydemo.exceptions.GenericExceptions;
import com.sda.springsecuritydemo.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<UserEntity> user = userRepository.findByUsername(username);
        if (user.isPresent()){
            return new UserDetailsImpl(user.get());
        } else {
         throw GenericExceptions.userNotFoundException("username", username);
        }
    }
}
