package com.tomash.gombosh.api.util;

/**
 * @author Tomash Gombosh
 * @since 1.0.0
 */
public final class ApplicationProperties {
    public static final String API_CLIENT_URL = System.getProperty("api.client.url", "https://reqres.in/");

    private ApplicationProperties() {
        throw new AssertionError("Suppress default constructor for noninstantiability");
    }
}
