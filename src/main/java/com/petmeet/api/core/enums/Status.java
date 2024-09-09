package com.petmeet.api.core.enums;

import lombok.Getter;

/**
 * 데이터 상태를 관리하기 위한 이넘 클래스
 */
@Getter
public enum Status {

    ACTIVE("활성"),
    DELETED("삭제");

    private final String description;

    Status(String description) { this.description = description; }
}
