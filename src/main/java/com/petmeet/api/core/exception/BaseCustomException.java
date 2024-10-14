package com.petmeet.api.core.exception;

import com.petmeet.api.core.exception.errorcode.BaseErrorCode;
import lombok.Getter;

@Getter
public class BaseCustomException extends RuntimeException{

    private final BaseErrorCode errorCode;

    BaseCustomException(BaseErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
