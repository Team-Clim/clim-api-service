package com.example.climserver.domain.auth.application;

import com.example.climserver.domain.auth.dto.request.SignupRequest;
import com.example.climserver.domain.auth.exception.InvalidRoleException;
import com.example.climserver.domain.user.dao.UserRepository;
import com.example.climserver.domain.user.entity.User;
import com.example.climserver.domain.user.entity.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SignupService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public void signup(SignupRequest request) {
        if (request.getRole() == Role.BASIC) {
            User user = userRepository.save(
                    User.builder()
                            .email(request.getEmail())
                            .username(request.getUsername())
                            .password(passwordEncoder.encode(request.getPassword()))
                            .class_number(request.getClass_number())
                            .personal_number(request.getPersonal_number())
                            .grade(request.getGrade())
                            .role(Role.BASIC)
                            .build()
            );
        } else if (request.getRole() == Role.ADMIN) {
            User user = userRepository.save(
                    User.builder()
                            .email(request.getEmail())
                            .username(request.getUsername())
                            .password(passwordEncoder.encode(request.getPassword()))
                            .role(Role.ADMIN)
                            .build()
            );
        } else {
            throw InvalidRoleException.EXCEPTION;
        }
    }
}
