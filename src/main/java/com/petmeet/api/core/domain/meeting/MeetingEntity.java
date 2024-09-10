package com.petmeet.api.core.domain.meeting;

import com.petmeet.api.core.domain.common.BaseTimeEntity;
import com.petmeet.api.core.domain.user.UserEntity;
import com.petmeet.api.core.enums.Status;
import com.petmeet.api.core.enums.MeetingCategory;
import com.petmeet.api.core.enums.MeetingProgressStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "meeting")
@Builder
public class MeetingEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ElementCollection
    @CollectionTable(
            name = "meeting_images",
            joinColumns = @JoinColumn(name = "meeting_id")
    )
    private Set<String> imageUrls = new HashSet<>();

    private String title;
    private String content;
    private LocalDate date;
    private LocalTime time;
    private String location;
    private double latitude;
    private double longitude;
    private boolean petAllowed;

    @Enumerated(EnumType.STRING)
    private MeetingCategory category;

    @Enumerated(EnumType.STRING)
    private MeetingProgressStatus progressStatus;

    // 모집 관련 필드
    private LocalDateTime recruitmentStartedAt;
    private LocalDateTime recruitmentEndedAt;
    private int minPerson;
    private int maxPerson;

    private int participantTotal;
    private int markTotal;

    @Enumerated(EnumType.STRING)
    private Status status;
}
