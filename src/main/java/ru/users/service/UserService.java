package ru.users.service;

import ru.users.model.dto.ext.request.UserRequest;
import ru.users.model.entity.User;

public interface UserService {
    User getUser(long id);

    User createUser(UserRequest request);

    User updateUser(String id, UserRequest request);

    void deleteUser(Long id);


}
