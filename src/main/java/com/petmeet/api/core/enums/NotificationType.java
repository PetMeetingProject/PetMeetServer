package com.petmeet.api.core.enums;

import lombok.Getter;

/**
 * 푸시알림의 종류를 관리하기 위한 이넘 클래스
 */
@Getter
public enum NotificationType {

    // 모임 참여 관련
    MEETING_PARTICIPATION_REQUEST("모임 참여 신청 알림"),
    MEETING_PARTICIPATION_APPROVED("모임 참여 승인 알림"),
    MEETING_PARTICIPATION_REJECTED("모임 참여 거절 알림"),

    // 모임 진행 관련
    MEETING_START_REMINDER("모임 사전 알림"),
    MEETING_UPDATED("모임 수정 알림"),

    // 커뮤니티 관련 알림
    COMMENT_NOTIFICATION("댓글 알림"),
    REVIEW_NOTIFICATION("리뷰 알림"),

    // 계정 관련 알림
    TRUST_LEVEL_CHANGED("신뢰 등급 변동 알림");

    private final String description;

    NotificationType(String description) { this.description = description; }
}
