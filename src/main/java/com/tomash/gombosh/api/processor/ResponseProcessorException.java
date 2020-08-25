package com.tomash.gombosh.api.processor;

/**
 * @author Tomash Gombosh
 * @since 1.0.0
 */
class ResponseProcessorException extends RuntimeException {
    private static final long serialVersionUID = -7318854003532955321L;

    ResponseProcessorException(final String message, final Throwable cause) {
        super(message, cause);
    }
}
