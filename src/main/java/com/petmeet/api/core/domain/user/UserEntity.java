package com.petmeet.api.core.domain.user;

import com.petmeet.api.core.domain.common.BaseTimeEntity;
import com.petmeet.api.core.enums.Status;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "users")
@Builder
public class UserEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;
    private String nickname;
    private String intro;
    private int score;

    @Enumerated(EnumType.STRING)
    private Status status;
}
