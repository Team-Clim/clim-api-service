package com.example.climserver.domain.auth.exception;

import com.example.climserver.global.error.exception.ClimException;
import com.example.climserver.global.error.exception.ErrorCode;

public class RoomNumberExistException extends ClimException {
    public static final ClimException EXCEPTION = new RoomNumberExistException();

    public RoomNumberExistException() {
        super(ErrorCode.ROOM_NUMBER_EXIST);
    }
}
