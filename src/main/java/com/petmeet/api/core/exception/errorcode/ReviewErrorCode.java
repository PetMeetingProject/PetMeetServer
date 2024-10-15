package com.petmeet.api.core.exception.errorcode;

import org.springframework.http.HttpStatus;

/**
 * 리뷰 관련 에러코드
 */
public enum ReviewErrorCode implements BaseErrorCode{

    INVALID_DATA(HttpStatus.BAD_REQUEST, "Invalid review request data"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "Review does not exist"),
    ALREADY_DATA(HttpStatus.CONFLICT, "Conflict due to duplicate review data");

    private final HttpStatus httpStatus;
    private final String message;

    ReviewErrorCode(HttpStatus httpStatus, String message) {
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
