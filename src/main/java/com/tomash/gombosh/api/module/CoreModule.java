package com.tomash.gombosh.api.module;

import com.google.inject.AbstractModule;
import com.tomash.gombosh.api.processor.ResponseProcessor;
import com.tomash.gombosh.api.rest.RestClient;

import static com.google.inject.Scopes.SINGLETON;

/**
 * @author Tomash Gombosh
 * @since 1.0.0
 */
public class CoreModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ResponseProcessor.class).in(SINGLETON);
    }

    private RestClient restClient(final String baseUrl) {
        return new RestClient(baseUrl);
    }

}
