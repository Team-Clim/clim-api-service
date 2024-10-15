package com.example.climserver.domain.auth.dto.request;

import com.example.climserver.domain.user.entity.enums.Grade;
import com.example.climserver.domain.user.entity.enums.Role;
import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class SignupRequest {

    @NotBlank
    private String username;

    @NotBlank
    private String email;

    @NotBlank
    @Size(min = 8, max = 16, message = "비밀번호는 8~16글자 입니다.")
    private String password;

    @Min(1)
    @Max(4)
    @NotBlank
    private int classNumber;

    @Min(1)
    @Max(16)
    @NotBlank
    private int personalNumber;

    @Enumerated(EnumType.STRING)    //문자열로 저장 예: FIRST, SECOND
    @NotBlank
    private Grade grade;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
}
