package ru.users.exceptions;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(toBuilder = true)
public class ErrorMessage {
    private final String errorCode;
    private final String message;
}
