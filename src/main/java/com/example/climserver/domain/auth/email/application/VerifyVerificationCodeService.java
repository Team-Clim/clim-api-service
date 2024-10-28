package com.example.climserver.domain.auth.email.application;

import com.example.climserver.domain.auth.dto.request.SignupRequest;
import com.example.climserver.domain.auth.exception.VerificationFailedException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VerifyVerificationCodeService {
    private final VerificationCodeService verificationCodeService;

    public void verifyVerificationCode(SignupRequest request, String verificationCode) {
        if (!verificationCodeService.verifyCode(request.getEmail(), verificationCode)) {
            throw VerificationFailedException.EXCEPTION;
        }
    }
}
