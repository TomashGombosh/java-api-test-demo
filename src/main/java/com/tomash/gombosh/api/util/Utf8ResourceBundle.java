package com.tomash.gombosh.api.util;

import java.nio.charset.StandardCharsets;
import java.util.Enumeration;
import java.util.ResourceBundle;
import javax.annotation.Nonnull;

/**
 * @author Tomash Gombosh
 * @since 1.0.0
 */
public class Utf8ResourceBundle extends ResourceBundle {
    /**
     * Bundle with unicode data
     */
    private final ResourceBundle bundle;

    /**
     * Initializing constructor
     *
     * @param bundle resource bundle
     */
    public Utf8ResourceBundle(final ResourceBundle bundle) {
        this.bundle = bundle;
    }

    @Override
    protected Object handleGetObject(@Nonnull final String key) {
        final String value = bundle.getString(key);
        return new String(value.getBytes(StandardCharsets.ISO_8859_1), StandardCharsets.UTF_8);
    }

    @Override
    @Nonnull
    public Enumeration<String> getKeys() {
        return bundle.getKeys();
    }
}
