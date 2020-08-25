package com.tomash.gombosh.api.service;

/**
 * @author Tomash Gombosh
 * @since 1.0.0
 */
public interface Converter<S, T> {
    T convert(S source);
}
