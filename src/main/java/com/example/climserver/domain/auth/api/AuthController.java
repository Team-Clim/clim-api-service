package com.example.climserver.domain.auth.api;

import com.example.climserver.domain.auth.application.*;
import com.example.climserver.domain.auth.dto.request.LoginRequest;
import com.example.climserver.domain.auth.dto.request.RefreshTokenRequest;
import com.example.climserver.domain.auth.dto.request.SignupRequest;
import com.example.climserver.domain.auth.dto.response.TokenResponse;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final SignupService signupService;
    private final LoginService loginService;
    private final EmailService emailService;
    private final VerificationCodeService verificationCodeService;
    private final ReissueService reissueService;

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signup(@RequestBody @Valid SignupRequest request, @RequestParam String verificationCode) {
        signupService.signup(request, verificationCode);
    }

    @PostMapping("/send-verification-code")
    public void sendVerificationCode(@RequestParam String email) throws MessagingException {
        String verificationCode = emailService.sendEmailVerification(email);
        verificationCodeService.saveVerificationCode(email, verificationCode);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid LoginRequest request) {
        return loginService.login(request);
    }

    @PostMapping("/re-issue")
    public TokenResponse reissue(RefreshTokenRequest request) {
        return reissueService.reissue(request);
    }
}
