package com.petmeet.api.core.exception.errorcode;

import org.springframework.http.HttpStatus;

/**
 * 인증, 인가 관련 에러코드
 */
public enum AuthErrorCode implements BaseErrorCode{

    // 유효하지 않은 토큰
    INVALID_TOKEN(HttpStatus.UNAUTHORIZED, "Invalid token"),

    // 만료된 토큰
    EXPIRED_TOKEN(HttpStatus.UNAUTHORIZED, "Expired token"),

    // 토큰 누락
    MISSING_TOKEN(HttpStatus.NOT_FOUND, "Token not found"),

    // 토큰 갱신 실패 ( 유효하지 않은 리프레시 토큰 )
    TOKEN_REFRESH_FAILED(HttpStatus.BAD_REQUEST, "Token Refresh failed"),

    // 유효하지 않은 자격 증명, 인증 ( 인증 실패 )
    INVALID_CREDENTIALS(HttpStatus.UNAUTHORIZED, "Invalid credentials"),

    // 접근 권한 없음 ( 인증되지 않은 사용자가 인증이 필요한 리소스에 접근할 경우 )
    UNAUTHORIZED_ACCESS(HttpStatus.FORBIDDEN, "Unauthorized access."),

    // 권한 부족 ( 인증은 성공했지만 접근 권한이 부족한 경우, ex. 일반 사용자가 관리자 페이지에 접근 요청할 경우 )
    INSUFFICIENT_PERMISSIONS(HttpStatus.FORBIDDEN, "Insufficient permissions."),

    // 유효하지 않은 Authorization Header ( Authorization Header 누락 )
    INVALID_AUTHORIZATION_HEADER(HttpStatus.UNAUTHORIZED, "Invalid authorization header."),

    // 유효하지 않은 OAuth 제공자
    INVALID_OAUTH_PROVIDER(HttpStatus.FORBIDDEN, "Invalid oauth provider.");

    private final HttpStatus httpStatus;
    private final String message;

    AuthErrorCode(HttpStatus httpStatus, String message) {
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
