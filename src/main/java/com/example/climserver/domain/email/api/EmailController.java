package com.example.climserver.domain.email.api;

import com.example.climserver.domain.email.application.EmailService;
import com.example.climserver.domain.email.application.VerificationCodeService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class EmailController {
    private final EmailService emailService;
    private final VerificationCodeService verificationCodeService;

    @PostMapping("/send-verification-code")
    public void sendVerificationCode(@RequestParam String email) throws MessagingException {
        String verificationCode = emailService.sendEmailVerification(email);
        verificationCodeService.saveVerificationCode(email, verificationCode);
    }
}
