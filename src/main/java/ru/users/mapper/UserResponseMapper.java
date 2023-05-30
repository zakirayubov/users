package ru.users.mapper;

import org.springframework.stereotype.Component;
import ru.users.model.dto.ext.UserResponseExt;
import ru.users.model.entity.User;

@Component
public class UserResponseMapper implements Mapper <User, UserResponseExt> {

    @Override
    public UserResponseExt map(User source) {
        if (source == null) {
            return null;
        }

        return UserResponseExt.builder()
                .id(String.valueOf(source.getId()))
                .nickName(source.getNickName())
                .firstName(source.getFirstName())
                .lastName(source.getLastName())
                .gender(source.getGender())
                .brithDate(source.getBrithDate())
                .email(source.getEmail())
                .build();
    }
}
