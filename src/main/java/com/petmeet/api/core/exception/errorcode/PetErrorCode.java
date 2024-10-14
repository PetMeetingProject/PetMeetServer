package com.petmeet.api.core.exception.errorcode;

import org.springframework.http.HttpStatus;

/**
 * 반려동물 관련 에러코드
 */
public enum PetErrorCode implements BaseErrorCode{

    INVALID_DATA(HttpStatus.BAD_REQUEST, "Invalid pet request data"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "Pet does not exist"),
    ALREADY_DATA(HttpStatus.CONFLICT, "Conflict due to duplicate pet data");

    private final HttpStatus httpStatus;
    private final String message;

    PetErrorCode(HttpStatus httpStatus, String message) {
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
