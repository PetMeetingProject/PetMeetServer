package com.petmeet.api.core.enums;

import lombok.Getter;

/**
 * 모임의 카테고리 종류를 관리하기 위한 이넘 클래스
 */
@Getter
public enum MeetingCategory {

    ACTIVITY("산책 및 활동"),
    NETWORKING("네트워킹(카페, 식당 등)"),
    VOLUNTEERING("봉사"),
    OTHER("기타");

    private final String description;

    MeetingCategory(String description) { this.description = description; }
}
