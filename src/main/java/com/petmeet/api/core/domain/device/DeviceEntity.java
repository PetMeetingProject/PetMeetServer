package com.petmeet.api.core.domain.device;

import com.petmeet.api.core.domain.common.BaseTimeEntity;
import com.petmeet.api.core.domain.user.UserEntity;
import com.petmeet.api.core.enums.Status;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "device")
@Builder
public class DeviceEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    private String accessToken;
    private String refreshToken;
    private String appVersion;
    private String appOsType;
    private String appLanguage;
    private String fcmToken;

    @Enumerated(EnumType.STRING)
    private Status status;
}
