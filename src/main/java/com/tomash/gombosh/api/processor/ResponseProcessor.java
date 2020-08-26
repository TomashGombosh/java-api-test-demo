package com.tomash.gombosh.api.processor;

import java.io.IOException;
import java.util.Optional;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import lombok.extern.log4j.Log4j2;
import okhttp3.ResponseBody;
import retrofit2.Response;

import static java.util.Objects.nonNull;
import static java.util.Optional.empty;
import static java.util.Optional.ofNullable;
import static org.apache.commons.lang3.reflect.FieldUtils.readField;

/**
 * @author Tomash Gombosh
 * @since 1.0.0
 */
@Log4j2
public class ResponseProcessor {
    /**
     * Extract error message from {@link Throwable}.
     *
     * @param throwable throwable
     * @return error message
     * @see Throwable
     * @see ResponseProcessor#extractErrorMessage(Response)
     */
    public Optional<String> extractErrorMessage(final Throwable throwable) {
        final Response<?> response;
        try {
            response = (Response) readField(throwable, "response", true);
        } catch (final IllegalAccessException | IllegalArgumentException e) {
            return ofNullable(throwable.getMessage());
        }
        return extractErrorMessage(response);
    }

    /**
     * Extract error message from {@link Response}.
     *
     * @param response response
     * @return error message
     * @see Response
     * @see ErrorResponse
     */
    public Optional<String> extractErrorMessage(final Response<?> response) {
        try {
            final ResponseBody responseBody = response.errorBody();
            if (nonNull(responseBody)) {
                final String errorJson = responseBody.string();
                final Gson gson = new Gson();
                try {
                    final ErrorResponse errorResponse = gson.fromJson(errorJson, ErrorResponse.class);
                    if (nonNull(errorResponse)) {
                        return ofNullable(errorResponse.getErrorMessage());
                    } else {
                        return empty();
                    }
                } catch (final JsonSyntaxException e) {
                    log.error("Response body: {}", responseBody.toString());
                    throw new ResponseProcessorException("Unable to serialized error response", e);
                }
            }
            return empty();
        } catch (final IOException e) {
            throw new ResponseProcessorException("Unable to extract error message from response body", e);
        }
    }
}
