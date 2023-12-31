package com.emperor.Eko.Apartment.rental.system.config;

import com.emperor.Eko.Apartment.rental.system.entity.security.Token;
import com.emperor.Eko.Apartment.rental.system.exceptions.ResourceNotFoundException;
import com.emperor.Eko.Apartment.rental.system.repository.TokenRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutHandler;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class LogoutService implements LogoutHandler {

    private TokenRepository tokenRepository;
    @Override
    public void logout(HttpServletRequest request,
                       HttpServletResponse response,
                       Authentication authentication) {

        final String authHeader = request.getHeader("Authorization");

        if (authHeader == null || !authHeader.startsWith("Bearer ")){
            return;
        }
        String jwt = authHeader.substring(7);
        Token token = tokenRepository.findByToken(jwt).orElseThrow(() -> new ResourceNotFoundException("Token not found"));
        if (token != null){
            token.setExpired(true);
            token.setRevoked(true);
            tokenRepository.save(token);
        }

    }
}
