package com.example.climserver.domain.auth.email.application;

import com.example.climserver.domain.auth.dto.request.SignupRequest;
import com.example.climserver.domain.auth.exception.EmailExistException;
import com.example.climserver.domain.user.dao.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckEmailService {
    private final UserRepository userRepository;
    public void checkEmail(SignupRequest request) {
        if (userRepository.findByEmail(request.getEmail()).isPresent()) {
            throw EmailExistException.EXCEPTION;
        }
    }
}
