package com.petmeet.api.core.domain.review;

import com.petmeet.api.core.domain.common.BaseTimeEntity;
import com.petmeet.api.core.domain.meeting.MeetingEntity;
import com.petmeet.api.core.domain.user.UserEntity;
import com.petmeet.api.core.enums.Status;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "review")
@Builder
public class ReviewEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "meeting_id", nullable = false)
    private MeetingEntity meeting;

    @ElementCollection
    @CollectionTable(
            name = "review_images",
            joinColumns = @JoinColumn(name = "review_id")
    )
    private Set<String> imageUrls = new HashSet<>();

    private String content;

    private double point;

    @Enumerated(EnumType.STRING)
    private Status status;
}
