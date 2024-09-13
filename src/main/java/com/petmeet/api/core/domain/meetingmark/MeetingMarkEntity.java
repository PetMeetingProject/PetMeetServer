package com.petmeet.api.core.domain.meetingmark;

import com.petmeet.api.core.domain.common.BaseTimeEntity;
import com.petmeet.api.core.domain.meeting.MeetingEntity;
import com.petmeet.api.core.domain.user.UserEntity;
import com.petmeet.api.core.enums.Status;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "meeting_mark")
@Builder
public class MeetingMarkEntity extends BaseTimeEntity {

    @EmbeddedId
    private MeetingMarkEmbeddedId id;

    @ManyToOne
    @MapsId("userId")
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @MapsId("meetingId")
    @JoinColumn(name = "meeting_id", nullable = false)
    private MeetingEntity meeting;


    @Enumerated(EnumType.STRING)
    private Status status;
}
