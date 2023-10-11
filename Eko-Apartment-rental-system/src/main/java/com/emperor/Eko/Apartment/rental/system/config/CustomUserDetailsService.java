package com.emperor.Eko.Apartment.rental.system.config;

import com.emperor.Eko.Apartment.rental.system.entity.UserType;
import com.emperor.Eko.Apartment.rental.system.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserType user = userRepository.findByUsernameOrEmail(username, username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
        return new CustomUserDetails(user);
    }
}
