package com.example.climserver.domain.auth.exception;

import com.example.climserver.global.error.exception.ClimException;
import com.example.climserver.global.error.exception.ErrorCode;

public class EmailExistException extends ClimException {
    public static final ClimException EXCEPTION = new EmailExistException();

    public EmailExistException() {
        super(ErrorCode.EMAIL_EXIST);
    }
}
