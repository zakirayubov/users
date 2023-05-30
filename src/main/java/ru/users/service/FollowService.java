package ru.users.service;

import ru.users.model.dto.ext.request.FollowRequest;
import ru.users.model.entity.Follow;

import java.util.List;

public interface FollowService {
    List<Follow> getFollowings(Long followerId);

    List<Follow> getFollowers(Long followingId);

    Follow createFollow(FollowRequest request);

    void deleteFollow(Long id);
}
