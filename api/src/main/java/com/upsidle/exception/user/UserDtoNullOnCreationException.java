package com.upsidle.exception.user;

import java.io.Serial;

/**
 * Responsible null user dto on creation exception specifically.
 *
 * @author Matthew Puentes
 * @version 1.0
 * @since 1.0
 */
public class UserDtoNullOnCreationException extends RuntimeException {
    @Serial
    private static final long serialVersionUID = -3359345756622417883L;

    /**
     * Constructs a new runtime exception with the specified detail message. The cause is not
     * initialized, and may subsequently be initialized by a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for later retrieval by the
     *     {@link #getMessage()} method.
     */
    public UserDtoNullOnCreationException(String message) {
        super(message);
    }
}
