package com.petmeet.api.core.domain.comment;

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
@Table(name = "comment")
@Builder
public class CommentEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "meeting_id", nullable = false)
    private MeetingEntity meeting;

    private String content;

    @Enumerated(EnumType.STRING)
    private Status status;
}
