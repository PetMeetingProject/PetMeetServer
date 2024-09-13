package com.petmeet.api.core.domain.pettype;

import com.petmeet.api.core.domain.common.BaseTimeEntity;
import com.petmeet.api.core.enums.Status;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Table(name = "pet_type")
@Builder
public class PetTypeEntity extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private String breed;

    @Enumerated(EnumType.STRING)
    private Status status;
}
