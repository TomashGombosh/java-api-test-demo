package com.tomash.gombosh.api.service;

/**
 * @author Tomash Gombosh
 * @since 1.0.0
 */
public final class HttpStatus {
    public static final int OK_STATUS = 200;
    public static final int CREATED = 201;
    public static final int NO_CONTENT = 204;

    private HttpStatus() {
        throw new AssertionError("Suppress default constructor for noninstantiability");
    }
}
