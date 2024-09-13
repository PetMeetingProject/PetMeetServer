package com.petmeet.api.core.enums;

import lombok.Getter;

/**
 * 모임 멤버 참석 상태를 관리하기 위한 이넘 클래스
 */
@Getter
public enum MeetingMemberAttendanceStatus {

    NON_ARRIVAL("도착전"),
    ARRIVAL("도착"),
    LATE("지각"),
    NO_SHOW("노쇼");

    private final String description;

    MeetingMemberAttendanceStatus(String description) { this.description = description; }
}
