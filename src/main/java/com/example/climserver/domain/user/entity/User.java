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
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", length = 50)
    private String username;

    @Pattern(
            regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$",
            message = "잘못된 email형식입니다."
    )
    @Column(name = "email", length = 100, unique = true, nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Min(1)
    @Max(4)
    @Column(name = "class_number", nullable = false)
    private Integer classNumber;

    @Min(1)
    @Max(16)
    @Column(name = "number", nullable = false)
    private Integer personalNumber;

    @Enumerated(EnumType.STRING)    //문자열로 저장 예: FIRST, SECOND
    @Column(nullable = false)
    private Grade grade;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;
}
