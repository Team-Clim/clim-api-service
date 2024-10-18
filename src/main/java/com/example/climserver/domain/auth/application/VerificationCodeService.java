package com.example.climserver.domain.auth.application;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class VerificationCodeService {
    private final Map<String, String> verificationCodes = new HashMap<>();

    //이메일 인증 코드 저장
    public void saveVerificationCode(String email, String code) {
        verificationCodes.put(email, code);
    }

    //이메일 코드 검사
    public boolean verifyCode(String email, String code) {
        return verificationCodes.containsKey(email) && verificationCodes.get(email).equals(code);
    }

    //인증 후 삭제
    public void removeVerificationCode(String email) {
        verificationCodes.remove(email);
    }
}
