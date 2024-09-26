package com.petmeet.api.core.enums;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum SuccessResponseType {

    SUCCESS(HttpStatus.OK, "Request was successful"),
    CREATED(HttpStatus.CREATED, "Resource was created successfully"),
    UPDATED_WITH_CONTENT(HttpStatus.OK, "Resource was updated successfully"),
    UPDATED(HttpStatus.NO_CONTENT, "Resource was updated successfully"),
    DELETED_WITH_CONTENT(HttpStatus.OK, "Resource was deleted successfully"),
    DELETED(HttpStatus.NO_CONTENT, "Resource was deleted successfully");

    private final HttpStatus httpStatus;
    private final String message;

    SuccessResponseType(HttpStatus httpStatus, String message) {
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
