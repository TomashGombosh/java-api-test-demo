package com.tomash.gombosh.api.service;

import java.util.function.Consumer;

/**
 * @author Tomash Gombosh
 * @since 1.0.0
 */
public interface Factory<T, R extends Factory<T, R>> {
    T create();

    @SuppressWarnings("unchecked")
    default R with(final Consumer<R> consumer) {
        final R result = (R) this;
        consumer.accept(result);
        return result;
    }
}
