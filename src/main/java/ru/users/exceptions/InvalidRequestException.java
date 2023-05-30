package ru.users.exceptions;


/**
 * Используется для сообщения об ошибках в передаваемых параметрах клиенту.
 * Сообщение и код ошибки проксирюется фронту.
 */
public class InvalidRequestException extends CustomCodeException {

    public InvalidRequestException(String msg) {
        super(msg, ErrorCodes.BAD_REQUEST.name());
    }

    public InvalidRequestException(String msg, String errorCode) {
        super(msg, errorCode);
    }

}
