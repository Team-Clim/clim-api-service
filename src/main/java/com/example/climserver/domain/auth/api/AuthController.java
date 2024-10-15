package com.example.climserver.domain.auth.api;

import com.example.climserver.domain.auth.application.LoginService;
import com.example.climserver.domain.auth.application.SignupService;
import com.example.climserver.domain.auth.dto.request.LoginRequest;
import com.example.climserver.domain.auth.dto.request.SignupRequest;
import com.example.climserver.domain.auth.dto.response.TokenResponse;
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

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    public void signup(@RequestBody @Valid SignupRequest request) {
        signupService.signup(request);
    }

    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/login")
    public TokenResponse login(@RequestBody @Valid LoginRequest request) {
        return loginService.login(request);
    }
}
