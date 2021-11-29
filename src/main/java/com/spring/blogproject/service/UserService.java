package com.spring.blogproject.service;

import com.spring.blogproject.entity.Role;
import com.spring.blogproject.entity.User;
import com.spring.blogproject.entity.UserRegistration;
import com.spring.blogproject.repository.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.UUID;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User %s does not exist", username)));
    }

    public void createNewUser(UserRegistration registration) {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();

        User user = new User(registration.getUsername(),
                encoder.encode(registration.getPassword()),
                registration.getEmail(),
                Set.of(new Role(UUID.fromString("60dbb7bb-99a0-42eb-a837-8be6b697c074"), "USER")));
        userRepository.save(user);
    }
}
