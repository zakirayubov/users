package ru.users.model.dto.ext;

import lombok.Builder;
import lombok.Data;

import java.time.OffsetDateTime;

@Data
@Builder(toBuilder = true)
public class FollowResponseExt {
    private String id;
    private String followingId;
    private String followerId;
    private OffsetDateTime followedAt;
}
