package ru.users.model.dto.ext.request;

import lombok.Data;

@Data
public class UserRequest {
    private String id;
    private String nickName;
    private String firstName;
    private String lastName;
    private String gender;
    private String brithDate;
    private String email;
    private String status;
}
