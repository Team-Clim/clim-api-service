package com.example.climserver.domain.auth.application;

import com.example.climserver.domain.auth.dto.request.SignupRequest;
import com.example.climserver.domain.auth.exception.RoomNumberExistException;
import com.example.climserver.domain.user.dao.UserRepository;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckRoomNumberService {
    private final UserRepository userRepository;

    public void CheckRoomNumber(SignupRequest request) {
        if(userRepository.findByRoomNumber(request.getRoomNumber()).isPresent()) {
            throw RoomNumberExistException.EXCEPTION;
        }
    }
}
