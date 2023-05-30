package ru.users.model.dto.ext.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class FollowRequest {
    @JsonProperty(required = true)
    private Long followingId;

    @JsonProperty(required = true)
    private Long followerId;
}
