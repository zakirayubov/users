package ru.users.controller;

import org.springframework.web.bind.annotation.*;
import ru.users.mapper.Mapper;
import ru.users.model.dto.ext.UserResponseExt;
import ru.users.model.dto.ext.request.UserRequest;
import ru.users.model.entity.User;
import ru.users.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UsersController {

    private final UserService userService;
    private final Mapper<User, UserResponseExt> userResponseMapper;

    public UsersController(UserService userService, Mapper<User, UserResponseExt> userResponseMapper) {
        this.userService = userService;
        this.userResponseMapper = userResponseMapper;
    }

    @GetMapping("/{id}")
    public UserResponseExt getUser(@PathVariable String id) {
        User user = userService.getUser(Long.parseLong(id));
        return userResponseMapper.map(user);
    }

    @PostMapping
    public UserResponseExt createUser(@RequestBody UserRequest request) {
        User user = userService.createUser(request);
        return userResponseMapper.map(user);
    }

    @PutMapping("/{id}")
    public UserResponseExt updateUser(@PathVariable String id, @RequestBody UserRequest request) {
        User user = userService.updateUser(id, request);
        return userResponseMapper.map(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable String id) {
        userService.deleteUser(Long.parseLong(id));
    }
}
