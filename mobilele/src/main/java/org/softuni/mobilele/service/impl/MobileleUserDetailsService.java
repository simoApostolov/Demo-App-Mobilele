package org.softuni.mobilele.service.impl;

import org.softuni.mobilele.model.entity.User;
import org.softuni.mobilele.model.entity.UserRole;
import org.softuni.mobilele.repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.List;

public class MobileleUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MobileleUserDetailsService(UserRepository userRepository) {

        this.userRepository = userRepository;
    }
    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userRepository
                .findByEmail(email)
                .map(MobileleUserDetailsService::map)
                .orElseThrow(() -> new UsernameNotFoundException("User " + email + "not found!"));
    }

    private static UserDetails map(User user) {
       return org.springframework.security.core.userdetails.User
                .withUsername(user.getEmail())
                .password(user.getPassword())
                .authorities(user.getRole().stream().map(MobileleUserDetailsService::map).toList())
                .build();
    }

    private static GrantedAuthority map(UserRole userRole) {
        return  new SimpleGrantedAuthority(
                "ROLE_" + userRole.getRole().name());
    }
}
