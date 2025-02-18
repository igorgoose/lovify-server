package by.lovify.constructor.exception;

import by.lovify.constructor.enums.Gender;
import by.lovify.common.exception.AbstractNotFoundException;

public class DefaultConfigNotFoundException extends AbstractNotFoundException {

    private static final String DEFAULT_CONFIG_NOT_FOUND_MESSAGE = "No config found with gender '%s'";

    public DefaultConfigNotFoundException(Gender gender) {
        super(DEFAULT_CONFIG_NOT_FOUND_MESSAGE.formatted(gender));
    }
}
