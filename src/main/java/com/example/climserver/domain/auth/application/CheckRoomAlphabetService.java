package com.example.climserver.domain.auth.application;

import com.example.climserver.domain.auth.dto.request.SignupRequest;
import com.example.climserver.domain.auth.exception.RoomAlphabetExistException;
import com.example.climserver.domain.user.dao.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckRoomAlphabetService {
    private final UserRepository userRepository;

    public void checkRoomAlphabet(SignupRequest request) {
        if(userRepository.findByRoomNumberAndRoomAlphabet(request.getRoomNumber(), request.getRoomAlphabet()).isPresent()) {
            throw RoomAlphabetExistException.EXCEPTION;
        }
    }
}
