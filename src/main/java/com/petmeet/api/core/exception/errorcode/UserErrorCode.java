package com.petmeet.api.core.exception.errorcode;

import org.springframework.http.HttpStatus;

/**
 * 회원 관련 에러코드
 */
public enum UserErrorCode implements BaseErrorCode{

    INVALID_DATA(HttpStatus.BAD_REQUEST, "Invalid user request data"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "User does not exist"),
    ALREADY_DATA(HttpStatus.CONFLICT, "Conflict due to duplicate user data");

    private final HttpStatus httpStatus;
    private final String message;

    UserErrorCode(HttpStatus httpStatus, String message) {
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
