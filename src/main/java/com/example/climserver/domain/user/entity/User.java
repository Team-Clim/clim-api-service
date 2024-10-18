package com.example.climserver.domain.user.entity;

import com.example.climserver.domain.user.entity.enums.Grade;
import com.example.climserver.domain.user.entity.enums.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.UUID;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2"    x)
    @Column(name = "id", columnDefinition = "BINARY(16)", unique = true, nullable = false)
    private UUID id;

    @Column(name = "username", nullable = false, length = 50)
    private String username;

    @NotBlank
    @Pattern(
            regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
            message = "Invalid email format"
    )
    @Column(name = "email", length = 100, nullable = false, unique = true)
    private String email;

    @NotBlank
    @Size(min = 8, max = 16, message = "비밀번호는 8~16글자 입니다.")
    @Pattern(
            regexp = "^(?=.*[0-9])(?=.*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>/?]).{8,16}$",
            message = "비밀번호는 숫자 하나 이상, 특수문자 하나 이상을 포함해야 하며, 8자에서 16자 사이여야 합니다."
    )
    private String password;

    @Size(max = 4, min = 1)
    @Column(name = "class", nullable = false)
    private int classNumber;

    @Size(max = 16, min = 1)
    @Column(name = "number", nullable = false)
    private int personalNumber;

    @Enumerated(EnumType.STRING)    //문자열로 저장 예: FIRST, SECOND
    @Column(nullable = false)
    private Grade grade;

    @Column(name = "profile_img_url")
    private String profileImgUrl;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
}
