package com.example.climserver.domain.auth.exception;

import com.example.climserver.global.error.exception.ClimException;

public class EmailExistException extends ClimException {
    public static final ClimException EXCEPTION = new EmailExistException();
}
