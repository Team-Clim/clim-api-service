package com.example.climserver.domain.auth.application;

import com.example.climserver.domain.auth.dto.request.LoginRequest;
import com.example.climserver.domain.auth.dto.response.TokenResponse;
import com.example.climserver.domain.auth.exception.PasswordMismatchException;
import com.example.climserver.domain.user.dao.UserRepository;
import com.example.climserver.domain.user.entity.User;
import com.example.climserver.domain.user.exception.UserNotFoundException;
import com.example.climserver.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtTokenProvider jwtTokenProvider;

    public TokenResponse login(LoginRequest request) {
        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);

        if (!passwordEncoder.matches(request.getPassword(), user.getPassword()))
            throw PasswordMismatchException.EXCEPTION;

        return jwtTokenProvider.receiveToken(request.getEmail());
    }
}
