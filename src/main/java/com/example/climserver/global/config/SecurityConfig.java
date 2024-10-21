package com.example.climserver.global.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http  // CSRF 비활성화
                .csrf(AbstractHttpConfigurer::disable);

        // Form 로그인 방식 비활성화
        http
                .formLogin(AbstractHttpConfigurer::disable);

        // HTTP Basic 인증 방식 비활성화
        http
                .httpBasic(AbstractHttpConfigurer::disable);

        // 경로별 인가 작업 (요청에 대한 권한을 설정)
        http
                .authorizeHttpRequests((auth) -> auth
                        // 정적 리소스에 대한 접근을 허용
                        .requestMatchers("/css/**", "/js/**", "/images/**", "/webjars/**").permitAll()

                        // 로그인, 회원가입, 인증코드 요청 경로는 모두 허용
                        .requestMatchers("/login", "/", "/auth/signup", "/auth/send-verification-code").permitAll()

                        // "/admin" 경로는 ADMIN 역할만 접근 가능
                        .requestMatchers("/admin").hasRole("ADMIN")

                        // 그 외 모든 요청은 인증된 사용자만 접근 가능
                        .anyRequest().authenticated()
                );

        // 세션 설정
        http
                .sessionManagement((session) -> session
                        .sessionCreationPolicy(SessionCreationPolicy.STATELESS));

        return http.build();
    }
}
