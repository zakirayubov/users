package ru.users.exceptions;

public class DataNotFoundException extends CustomCodeException {

    public DataNotFoundException(String msg) {
        super(msg, ErrorCodes.NOT_FOUND.name());
    }
}
