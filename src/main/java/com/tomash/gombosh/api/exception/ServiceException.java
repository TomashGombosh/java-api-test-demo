package com.tomash.gombosh.api.exception;

import java.io.Serializable;

import static org.apache.commons.lang3.StringUtils.LF;

/**
 * @author Tomash Gombosh
 * @since 1.0.0
 */
public class ServiceException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 6218472195517307497L;

    public ServiceException(final String message) {
        super(message);
    }

    public ServiceException(final String message, final Throwable cause) {
        super(message, cause);
    }

    public ServiceException(final String message, final String errorMessage) {
        super(message + LF + "Cause: " + errorMessage);
    }
}
