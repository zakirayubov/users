package ru.users.mapper;

import org.springframework.stereotype.Component;
import ru.users.model.dto.ext.FollowResponseExt;
import ru.users.model.entity.Follow;

@Component
public class FollowResponseMapper implements Mapper<Follow, FollowResponseExt> {

    @Override
    public FollowResponseExt map(Follow source) {
        return FollowResponseExt.builder()
                .id(String.valueOf(source.getId()))
                .followingId(String.valueOf(source.getFollowingId()))
                .followerId(String.valueOf(source.getFollowerId()))
                .followedAt(source.getFollowedAt())
                .build();
    }
}
