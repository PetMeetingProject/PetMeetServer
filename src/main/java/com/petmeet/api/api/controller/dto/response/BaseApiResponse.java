package com.petmeet.api.api.controller.dto.response;

import com.petmeet.api.core.enums.SuccessResponseType;
import com.petmeet.api.core.exception.errorcode.BaseErrorCode;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class BaseApiResponse<D> {

    private final HttpStatus httpStatus;
    private final String message;
    private final D data;

    private BaseApiResponse(HttpStatus httpStatus, String message, D data) {
        this.httpStatus = httpStatus;
        this.message = message;
        this.data = data;
    }

    // 성공 응답 (응답 데이터가 있는 경우)
    public static <D> BaseApiResponse<D> success(SuccessResponseType responseType, D data) {
        return new BaseApiResponse<>(responseType.getHttpStatus(), responseType.getMessage(), data);
    }

    // 성공 응답 (응답 데이터가 없는 경우)
    public static <D> BaseApiResponse<D> success(SuccessResponseType responseType) {
        return new BaseApiResponse<>(responseType.getHttpStatus(), responseType.getMessage(), null);
    }

    // 실패, 에러 응답 (커스텀 에러코드를 전달하는 경우)
    public static <D> BaseApiResponse<D> error(BaseErrorCode errorCode) {
        return new BaseApiResponse<>(errorCode.getHttpStatus(), errorCode.getMessage(), null);
    }

    // 실패, 에러 응답 (직접 HttpStatus, 메시지를 전달하는 경우)
    public static <D> BaseApiResponse<D> error(HttpStatus httpStatus, String message) {
        return new BaseApiResponse<>(httpStatus, message, null);
    }
}
