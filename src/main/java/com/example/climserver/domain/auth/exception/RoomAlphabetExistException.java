package com.example.climserver.domain.auth.exception;

import com.example.climserver.global.error.exception.ClimException;
import com.example.climserver.global.error.exception.ErrorCode;

public class RoomAlphabetExistException extends ClimException {
    public static final ClimException EXCEPTION = new RoomAlphabetExistException();

    public RoomAlphabetExistException() {
        super(ErrorCode.ROOM_ALPHABET_EXIST);
    }
}
