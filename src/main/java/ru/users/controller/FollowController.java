package ru.users.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.users.mapper.FollowResponseMapper;
import ru.users.model.dto.ext.FollowResponseExt;
import ru.users.model.dto.ext.request.FollowRequest;
import ru.users.model.entity.Follow;
import ru.users.service.FollowService;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/follow")
public class FollowController {

    private final FollowService followService;
    private final FollowResponseMapper followResponseMapper;

    @GetMapping("/followings/{followerId}")
    public List<FollowResponseExt>  getFollowings(@PathVariable Long followerId) {
        List<Follow> followings = followService.getFollowings(followerId);
        return new ArrayList<>(followResponseMapper.mapAll(followings));
    }

    @GetMapping("/followers/{followingId}")
    public List<FollowResponseExt>  getFollowers(@PathVariable Long followingId) {
        List<Follow> followings = followService.getFollowers(followingId);
        return new ArrayList<>(followResponseMapper.mapAll(followings));
    }

    @PostMapping
    public FollowResponseExt createFollow(@RequestBody FollowRequest request) {
        Follow follow = followService.createFollow(request);
        return followResponseMapper.map(follow);
    }

    @DeleteMapping("/{id}")
    public void deleteFollow(@PathVariable Long id) {
        followService.deleteFollow(id);
    }
}
