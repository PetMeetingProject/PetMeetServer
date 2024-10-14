package com.petmeet.api.core.exception.errorcode;

/**
 * 소셜 계정 관련 에러코드
 */

import org.springframework.http.HttpStatus;

public enum SocialAccountErrorCode implements BaseErrorCode{

    INVALID_DATA(HttpStatus.BAD_REQUEST, "Invalid social account request data"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "Social account does not exist"),
    ALREADY_DATA(HttpStatus.CONFLICT, "Conflict due to duplicate social account data");

    private final HttpStatus httpStatus;
    private final String message;

    SocialAccountErrorCode(HttpStatus httpStatus, String message) {
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
