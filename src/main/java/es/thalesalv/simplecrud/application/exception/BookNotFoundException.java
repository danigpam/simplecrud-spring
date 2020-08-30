package es.thalesalv.simplecrud.application.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class BookNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public BookNotFoundException(String message, Throwable t) {
        super(message, t);
    }

    public BookNotFoundException(String message) {
        super(message);
    }
}