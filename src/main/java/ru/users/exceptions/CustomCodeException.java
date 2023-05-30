package ru.users.exceptions;

import lombok.Getter;

public class CustomCodeException extends RuntimeException {

    @Getter
    protected final String errorCode;

    protected CustomCodeException(String msg, String errorCode) {
        super(msg);
        this.errorCode = errorCode;
    }
}
