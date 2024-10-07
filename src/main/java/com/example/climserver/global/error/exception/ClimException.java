package com.example.climserver.global.error.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ClimException extends RuntimeException {
    private final ErrorCode errorCode;
}
