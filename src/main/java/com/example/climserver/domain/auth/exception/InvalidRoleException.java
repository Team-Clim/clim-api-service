package com.example.climserver.domain.auth.exception;

import com.example.climserver.global.error.exception.ClimException;
import com.example.climserver.global.error.exception.ErrorCode;

public class InvalidRoleException extends ClimException {
    public static final ClimException EXCEPTION = new InvalidRoleException();

    public InvalidRoleException() {
        super(ErrorCode.INVALID_ROLE);
    }
}
