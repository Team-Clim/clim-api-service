package com.example.climserver.domain.auth.application;

import com.example.climserver.domain.auth.dao.RefreshTokenRepository;
import com.example.climserver.domain.auth.dto.request.RefreshTokenRequest;
import com.example.climserver.domain.auth.dto.response.TokenResponse;
import com.example.climserver.domain.auth.entity.RefreshToken;
import com.example.climserver.domain.auth.exception.RefreshTokenNotFoundException;
import com.example.climserver.global.security.jwt.JwtTokenProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@RequiredArgsConstructor
public class ReissueService {
    private final JwtTokenProvider jwtTokenProvider;

    private final RefreshTokenRepository refreshTokenRepository;

    @Transactional
    public TokenResponse reissue(RefreshTokenRequest request) throws IllegalAccessException {

        if (request.getToken() == null || request.getToken().isEmpty()) {
            throw new IllegalAccessException("refreshToken이 null이거나 비어있습니다");
        }

        RefreshToken refreshToken = refreshTokenRepository.findByToken(request.getToken())
                .orElseThrow(() -> RefreshTokenNotFoundException.EXCEPTION);
        return jwtTokenProvider.receiveToken(refreshToken.getEmail());
    }
}
