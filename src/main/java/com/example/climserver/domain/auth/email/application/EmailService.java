package com.example.climserver.domain.auth.email.application;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class EmailService {
    private final JavaMailSender mailSender;

    public String sendEmailVerification(String toEmail) throws MessagingException {
        String verificationCode = generateVerificationCode();   // 인증 코드 생성
        MimeMessage mimeMessage = mailSender.createMimeMessage();   // 이메일 메시지 생성
        MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, MimeMessageHelper.MULTIPART_MODE_MIXED_RELATED, "UTF-8");  // UTF-8 설정

        String htmlMsg = "<h1>이메일 인증 코드</h1>" +
                "<h3>인증 코드: <strong>" + verificationCode + "</strong></h3>";  // 이메일 본문
        mimeMessage.setContent(htmlMsg, "text/html; charset=UTF-8");  // 인코딩 설정

        helper.setTo(toEmail);  // 이메일 받을 대상 주소
        helper.setSubject("Clim 이메일 인증 코드");

        mailSender.send(mimeMessage);   // 이메일 전송

        return verificationCode;    // 인증 코드 반환
    }

    private String generateVerificationCode() {     // 인증 코드 생성 메서드
        Random random = new Random();
        return String.format("%06d", random.nextInt(1000000));  // 6자리 랜덤 숫자 생성
    }
}
