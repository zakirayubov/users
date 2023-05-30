package ru.users.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ResponseExceptionHandler {

    @ExceptionHandler(
            value = {
                    DataNotFoundException.class
            })
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMessage handleRequestParamsError(CustomCodeException exception) {
        log.warn("[Request params error]", exception);
        return ErrorMessage.builder()
                .errorCode(exception.getErrorCode())
                .message(exception.getMessage())
                .build();
    }
}
