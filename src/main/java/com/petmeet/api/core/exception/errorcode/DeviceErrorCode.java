package com.petmeet.api.core.exception.errorcode;

import org.springframework.http.HttpStatus;

/**
 * 기기 관련 에러코드
 */
public enum DeviceErrorCode implements BaseErrorCode{

    INVALID_DATA(HttpStatus.BAD_REQUEST, "Invalid device request data"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "Device does not exist"),
    ALREADY_DATA(HttpStatus.CONFLICT, "Conflict due to duplicate device data");

    private final HttpStatus httpStatus;
    private final String message;

    DeviceErrorCode(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }

    @Override
    public HttpStatus getHttpStatus() {
        return this.httpStatus;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
