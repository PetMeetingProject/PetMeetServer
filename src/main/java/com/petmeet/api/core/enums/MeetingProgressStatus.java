package com.petmeet.api.core.enums;

import lombok.Getter;

/**
 * 모임 진행 상태를 관리하기 위한 이넘 클래스
 */
@Getter
public enum MeetingProgressStatus {

    RECRUITMENT("모집"),
    BEFORE_START("시작전"),
    ONGOING("진행중"),
    FINISH("종료");

    private final String description;

    MeetingProgressStatus(String description) { this.description = description; }
}
