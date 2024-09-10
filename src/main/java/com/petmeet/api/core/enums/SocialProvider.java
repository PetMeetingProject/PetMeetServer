package com.petmeet.api.core.enums;

import lombok.Getter;

/**
 * 소셜 제공자 정보를 관리하기 위한 이넘 클래스
 */
@Getter
public enum SocialProvider {

    KAKAO("카카오"),
    APPLE("애플");

    private final String description;

    SocialProvider(String description) { this.description = description; }
}
