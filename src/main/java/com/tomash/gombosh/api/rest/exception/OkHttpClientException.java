package com.tomash.gombosh.api.rest.exception;

/**
 * @author Tomash Gombosh
 * @since 1.0.0
 */
public class OkHttpClientException extends RuntimeException {
    private static final long serialVersionUID = -1406018412594361005L;

    public OkHttpClientException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
