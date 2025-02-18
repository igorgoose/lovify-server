package by.lovify.common.exception;

import lombok.Getter;
import org.springframework.http.HttpStatusCode;

@Getter
public class AbstractBaseException extends RuntimeException {

    private final HttpStatusCode statusCode;

    protected AbstractBaseException(final HttpStatusCode statusCode, final String message) {
        super(message);
        this.statusCode = statusCode;
    }
}
