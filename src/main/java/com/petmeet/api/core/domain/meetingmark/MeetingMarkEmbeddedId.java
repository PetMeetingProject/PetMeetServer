package com.petmeet.api.core.domain.meetingmark;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Builder
public class MeetingMarkEmbeddedId implements Serializable {

    private Long userId;
    private Long meetingId;

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || getClass() != o.getClass()) return false;

        MeetingMarkEmbeddedId that = (MeetingMarkEmbeddedId) o;
        return Objects.equals(userId, that.userId) &&
                Objects.equals(meetingId, that.meetingId);
    }

    @Override
    public int hashCode() { return Objects.hash(userId, meetingId); }
}
