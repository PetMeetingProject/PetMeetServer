package com.petmeet.api.core.exception.errorcode;

import org.springframework.http.HttpStatus;

/**
 * 출석 기록 관련 에러코드
 */
public enum AttendanceRecordErrorCode implements BaseErrorCode{

    INVALID_DATA(HttpStatus.BAD_REQUEST, "Invalid attendance record request data"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "Attendance record does not exist"),
    ALREADY_DATA(HttpStatus.CONFLICT, "Conflict due to duplicate attendance record data");

    private final HttpStatus httpStatus;
    private final String message;

    AttendanceRecordErrorCode(HttpStatus httpStatus, String message) {
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
