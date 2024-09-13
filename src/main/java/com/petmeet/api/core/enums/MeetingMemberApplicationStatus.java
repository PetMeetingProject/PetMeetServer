package com.petmeet.api.core.enums;

import lombok.Getter;

/**
 * 모임 멤버 신청 상태를 관리하기 위한 이넘 클래스
 */
@Getter
public enum MeetingMemberApplicationStatus {

    PENDING("대기"),
    ACCEPTED("수락"),
    REJECTED("거절"),
    CANCELED("취소"),
    WITHDRAWN("탈퇴");

    private final String description;

    MeetingMemberApplicationStatus(String description) { this.description = description; }

}
