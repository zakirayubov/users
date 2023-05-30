package ru.users.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.users.exceptions.DataNotFoundException;
import ru.users.exceptions.ErrorMessages;
import ru.users.mapper.Mapper;
import ru.users.model.dto.ext.request.UserRequest;
import ru.users.model.entity.User;
import ru.users.model.internal.Gender;
import ru.users.model.internal.UserStatus;
import ru.users.repository.UserRepository;
import ru.users.service.UserService;

import java.time.LocalDate;


@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User getUser(long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new DataNotFoundException(ErrorMessages.USER_NOT_FOUND.getMessage()));
    }

    @Override
    @Transactional
    public User updateUser(String id, UserRequest request) {
        User user = userRepository.findById(Long.parseLong(id))
                .map(_user -> {
                            updateUserFields(request, _user);
                            return _user;
                        }
                ).orElseThrow(() -> new DataNotFoundException(ErrorMessages.USER_NOT_FOUND.getMessage()));
        return user;
    }

    @Override
    public User createUser(UserRequest request) {
        if (userRepository.findByNickName(request.getNickName()).isPresent()) {
            throw new RuntimeException("User already exists");
        }

        return userRepository.save(User.of(request));
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {
        int deleteUser = userRepository.deleteUserById(id, UserStatus.DELETED);

        if (deleteUser <= 0) {
            throw new DataNotFoundException(ErrorMessages.USER_NOT_FOUND.getMessage());
        }
    }

    private void updateUserFields(UserRequest request, User user) {
        user.setNickName(request.getNickName());
        user.setFirstName(request.getFirstName());
        user.setLastName(request.getLastName());
        user.setGender(Gender.fromValue(request.getGender()));
        user.setEmail(request.getEmail());
        user.setBrithDate(LocalDate.parse(request.getBrithDate()));
    }
}
