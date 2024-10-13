package com.example.climserver.domain.auth.exception;

import com.example.climserver.global.error.exception.ClimException;
import com.example.climserver.global.error.exception.ErrorCode;

public class ExpiredTokenException extends ClimException {
    public static final ClimException EXCEPTION = new ExpiredTokenException();

    public ExpiredTokenException() {
        super(ErrorCode.EXPIRED_TOKEN);
    }
}
