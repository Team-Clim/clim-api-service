package com.example.climserver.domain.auth.exception;

import com.example.climserver.global.error.exception.ClimException;
import com.example.climserver.global.error.exception.ErrorCode;

public class InvalidTokenException extends ClimException {
    public static final ClimException EXCEPTION = new InvalidTokenException();

    public InvalidTokenException() {
        super(ErrorCode.INVALID_TOKEN);
    }
}
