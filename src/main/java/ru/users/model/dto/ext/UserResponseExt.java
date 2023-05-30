package ru.users.model.dto.ext;

import lombok.Builder;
import lombok.Data;
import ru.users.model.internal.Gender;

import java.time.LocalDate;


@Data
@Builder(toBuilder = true)
public class UserResponseExt {
    private String id;
    private String nickName;
    private String firstName;
    private String lastName;
    private Gender gender;
    private LocalDate brithDate;
    private String email;
}
