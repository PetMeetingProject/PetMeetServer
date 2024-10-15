package com.petmeet.api.core.exception.errorcode;

import org.springframework.http.HttpStatus;

/**
 * 반려동물 종류 관련 에러코드
 */
public enum PetTypeErrorCode implements BaseErrorCode{

    INVALID_DATA(HttpStatus.BAD_REQUEST, "Invalid pet type request data"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "Pet type does not exist"),
    ALREADY_DATA(HttpStatus.CONFLICT, "Conflict due to duplicate pet type data");

    private final HttpStatus httpStatus;
    private final String message;

    PetTypeErrorCode(HttpStatus httpStatus, String message) {
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
