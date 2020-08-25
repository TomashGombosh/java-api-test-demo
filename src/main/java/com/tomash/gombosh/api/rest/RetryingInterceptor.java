package com.tomash.gombosh.api.rest;

import java.io.IOException;

import lombok.SneakyThrows;
import lombok.extern.log4j.Log4j2;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import org.jetbrains.annotations.NotNull;

/**
 * @author Tomash Gombosh
 * @since 1.0.0
 */
@Log4j2
public class RetryingInterceptor implements Interceptor {

    @SneakyThrows
    @NotNull
    @Override
    public Response intercept(@NotNull final Chain chain) {
        final int maxTries = 3;
        final int tryWait = 2000;
        boolean isSuccessful = false;
        int tryCount = 1;

        final Request request = chain.request();
        Response response = null;
        while (!isSuccessful && tryCount <= maxTries) {
            try {
                if (response != null) {
                    response.close();
                }
                response = chain.proceed(request);
                isSuccessful = response.isSuccessful();
            } catch (final IOException e) {
                log.warn("<-- {} {} ({} try isn't successful)", request.method(), request.url(), tryCount);
                Thread.sleep(tryWait);
            } finally {
                tryCount++;
            }
        }
        return response != null ? response : chain.proceed(request);
    }
}
