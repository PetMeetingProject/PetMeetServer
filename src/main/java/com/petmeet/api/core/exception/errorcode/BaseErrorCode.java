package com.petmeet.api.core.exception.errorcode;

import org.springframework.http.HttpStatus;

public interface BaseErrorCode {

    HttpStatus getHttpStatus();

    String getMessage();
}
