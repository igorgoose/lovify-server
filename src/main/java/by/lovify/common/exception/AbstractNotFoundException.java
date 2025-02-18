package by.lovify.common.exception;

import org.springframework.http.HttpStatus;

public class AbstractNotFoundException extends AbstractBaseException {

    protected AbstractNotFoundException(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
