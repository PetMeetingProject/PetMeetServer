package com.petmeet.api.core.exception.errorcode;

import org.springframework.http.HttpStatus;

/**
 * 댓글 관련 에러코드
 */
public enum CommentErrorCode implements BaseErrorCode{

    INVALID_DATA(HttpStatus.BAD_REQUEST, "Invalid comment request data"),
    NOT_FOUND(HttpStatus.NOT_FOUND, "Comment does not exist"),
    ALREADY_DATA(HttpStatus.CONFLICT, "Conflict due to duplicate comment data");

    private final HttpStatus httpStatus;
    private final String message;

    CommentErrorCode(HttpStatus httpStatus, String message) {
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
