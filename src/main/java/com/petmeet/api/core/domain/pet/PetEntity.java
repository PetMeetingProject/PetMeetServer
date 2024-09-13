package com.petmeet.api.core.domain.pet;

import com.petmeet.api.core.domain.common.BaseTimeEntity;
import com.petmeet.api.core.domain.pettype.PetTypeEntity;
import com.petmeet.api.core.domain.user.UserEntity;
import com.petmeet.api.core.enums.Status;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "pet")
@Builder
public class PetEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "pet_type_id", nullable = false)
    private PetTypeEntity petType;

    private String imageUrl;
    private String name;
    private int age;
    private int gender;
    private boolean neutered;
    private String intro;

    @Enumerated(EnumType.STRING)
    private Status status;
}
