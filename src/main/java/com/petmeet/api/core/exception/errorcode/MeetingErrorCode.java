package com.petmeet.api.core.exception.errorcode;

import org.springframework.http.HttpStatus;

/**
 * 모임 관련 에러코드
 */
public enum MeetingErrorCode implements BaseErrorCode{

    INVALID_DATA(HttpStatus.BAD_REQUEST, "Invalid meeting request data"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "Meeting does not exist"),
    ALREADY_DATA(HttpStatus.CONFLICT, "Conflict due to duplicate meeting data");

    private final HttpStatus httpStatus;
    private final String message;

    MeetingErrorCode(HttpStatus httpStatus, String message) {
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
