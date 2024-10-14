package com.petmeet.api.core.exception.errorcode;

import org.springframework.http.HttpStatus;

/**
 * 모임 멤버 관련 에러코드
 */
public enum MeetingMemberErrorCode implements BaseErrorCode{

    INVALID_DATA(HttpStatus.BAD_REQUEST, "Invalid meeting member request data"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "Meeting member does not exist"),
    ALREADY_DATA(HttpStatus.CONFLICT, "Conflict due to duplicate meeting member data");

    private final HttpStatus httpStatus;
    private final String message;

    MeetingMemberErrorCode(HttpStatus httpStatus, String message) {
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
