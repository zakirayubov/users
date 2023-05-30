package ru.users.exceptions;

import lombok.Getter;

public enum ErrorMessages {
    //common
    BAD_REQUEST("Неверный запрос"),
    USER_NOT_FOUND("Пользователь не найден"),
    FOLLOW_NOT_FOUND("Подписка не найдена");

    @Getter
    private final String message;

    ErrorMessages(String message) {
        this.message = message;
    }
}
