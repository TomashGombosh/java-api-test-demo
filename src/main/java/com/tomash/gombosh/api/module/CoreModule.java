package com.tomash.gombosh.api.module;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;

import com.tomash.gombosh.api.processor.ResponseProcessor;
import com.tomash.gombosh.api.rest.RestClient;
import com.tomash.gombosh.api.service.user.client.UserClient;

import static com.google.inject.Scopes.SINGLETON;
import static com.tomash.gombosh.api.util.ApplicationProperties.API_CLIENT_URL;

/**
 * @author Tomash Gombosh
 * @since 1.0.0
 */
public class CoreModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(ResponseProcessor.class).in(SINGLETON);
        bind(RestClient.class).toInstance(restClient(API_CLIENT_URL));
    }

    private RestClient restClient(final String baseUrl) {
        return new RestClient(baseUrl);
    }

    @Provides
    UserClient userClientService(final RestClient restClient) {
        return restClient.createService(UserClient.class);
    }
}
