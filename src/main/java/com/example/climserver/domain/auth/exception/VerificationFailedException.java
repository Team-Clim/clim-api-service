package com.example.climserver.domain.auth.exception;

import com.example.climserver.global.error.exception.ClimException;
import com.example.climserver.global.error.exception.ErrorCode;

public class VerificationFailedException extends ClimException {
    public static final ClimException EXCEPTION = new VerificationFailedException();

    public VerificationFailedException() {
        super(ErrorCode.VERIFICATION_FAILED);
    }

}
