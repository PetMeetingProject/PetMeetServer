package com.petmeet.api.core.domain.meetingmember;

import com.petmeet.api.core.domain.common.BaseTimeEntity;
import com.petmeet.api.core.domain.meeting.MeetingEntity;
import com.petmeet.api.core.domain.user.UserEntity;
import com.petmeet.api.core.enums.Status;
import com.petmeet.api.core.enums.MeetingMemberApplicationStatus;
import com.petmeet.api.core.enums.MeetingMemberAttendanceStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "meeting_member")
@Builder
public class MeetingMemberEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "meeting_id", nullable = false)
    private MeetingEntity meeting;

    private boolean petAccompanied;

    @Enumerated(EnumType.STRING)
    private MeetingMemberApplicationStatus applicationStatus;

    @Enumerated(EnumType.STRING)
    private MeetingMemberAttendanceStatus attendanceStatus;

    private LocalDateTime arrivalTime;

    @Enumerated(EnumType.STRING)
    private Status status;
}
