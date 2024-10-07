package com.example.climserver.domain.user.application.facade;

import com.example.climserver.domain.user.dao.UserRepository;
import com.example.climserver.domain.user.entity.User;
import com.example.climserver.domain.user.exception.NotAuthenticatedException;
import com.example.climserver.domain.user.exception.UserNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserFacade {
    private final UserRepository userRepository;

    public User currentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if(authentication == null || !authentication.isAuthenticated()) {
            throw new NotAuthenticatedException("인증 되지 않은 유저입니다.");
        }

        return userRepository.findByEmail(authentication.getName())
                .orElseThrow(() -> UserNotFoundException.EXCEPTION);
    }
}
