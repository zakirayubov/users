package ru.users.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.users.exceptions.DataNotFoundException;
import ru.users.exceptions.ErrorMessages;
import ru.users.exceptions.InvalidRequestException;
import ru.users.model.dto.ext.request.FollowRequest;
import ru.users.model.entity.Follow;
import ru.users.repository.FollowRepository;
import ru.users.service.FollowService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FollowServiceImpl implements FollowService {

    private final FollowRepository followRepository;

    @Override
    public List<Follow> getFollowings(Long followerId) {
        return followRepository.findByFollowerId(followerId);
    }

    @Override
    public List<Follow> getFollowers(Long followingId) {
        return followRepository.findByFollowingId(followingId);
    }

    @Override
    public Follow createFollow(FollowRequest request) {
        if (validate(request) && followRepository.findByFollowingIdAndFollowerId(request.getFollowingId(), request.getFollowerId()).isPresent()) {
            throw new InvalidRequestException(ErrorMessages.BAD_REQUEST.getMessage());
        }

        return followRepository.save(Follow.of(request));
    }

    @Override
    public void deleteFollow(Long id) {
        int deletedFollow = followRepository.deleteByFollowId(id);

        if (deletedFollow <= 0) {
            throw new DataNotFoundException(ErrorMessages.FOLLOW_NOT_FOUND.getMessage());
        }
    }

    private boolean validate(FollowRequest request) {
        return request.getFollowingId().equals(request.getFollowerId());
    }
 }
