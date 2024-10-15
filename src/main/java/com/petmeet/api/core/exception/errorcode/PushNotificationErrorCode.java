package com.petmeet.api.core.exception.errorcode;

import org.springframework.http.HttpStatus;

/**
 * 푸시알림 관련 에러코드
 */
public enum PushNotificationErrorCode implements BaseErrorCode{

    INVALID_DATA(HttpStatus.BAD_REQUEST, "Invalid push notification request data"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "Push notification does not exist"),
    ALREADY_DATA(HttpStatus.CONFLICT, "Conflict due to duplicate push notification data");

    private final HttpStatus httpStatus;
    private final String message;

    PushNotificationErrorCode(HttpStatus httpStatus, String message) {
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
