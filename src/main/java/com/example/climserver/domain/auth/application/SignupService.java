package com.example.climserver.domain.auth.application;

import com.example.climserver.domain.auth.dto.request.SignupRequest;
import com.example.climserver.domain.auth.email.application.CheckEmailService;
import com.example.climserver.domain.auth.email.application.VerificationCodeService;
import com.example.climserver.domain.auth.email.application.VerifyVerificationCodeService;
import com.example.climserver.domain.auth.exception.EmailExistException;
import com.example.climserver.domain.auth.exception.VerificationFailedException;
import com.example.climserver.domain.user.dao.UserRepository;
import com.example.climserver.domain.user.entity.User;
import com.example.climserver.domain.user.entity.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class SignupService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final VerificationCodeService verificationCodeService;
    private final CheckEmailService checkEmailService;
    private final VerifyVerificationCodeService verifyVerificationCodeService;

    @Transactional
    public void signup(SignupRequest request, String verificationCode) {

        //이메일 존재 여부
        checkEmailService.checkEmail(request);

        //인증 코드 검증
        verifyVerificationCodeService.verifyVerificationCode(request, verificationCode);

        User user = userRepository.save(
                User.builder()
                        .email(request.getEmail())
                        .username(request.getUsername())
                        .password(passwordEncoder.encode(request.getPassword()))
                        .classNumber(request.getClassNumber())
                        .personalNumber(request.getPersonalNumber())
                        .grade(request.getGrade())
                        .role(Role.BASIC)
                        .build()
        );

        //인증 후 인증 코드 삭제
        verificationCodeService.removeVerificationCode(request.getEmail());
    }
}
