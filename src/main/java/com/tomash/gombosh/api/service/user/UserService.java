package com.tomash.gombosh.api.service.user;

import java.util.concurrent.CompletableFuture;
import javax.inject.Inject;

import lombok.extern.log4j.Log4j2;

import com.tomash.gombosh.api.exception.ServiceException;
import com.tomash.gombosh.api.processor.ResponseProcessor;
import com.tomash.gombosh.api.service.user.client.UserClient;
import com.tomash.gombosh.api.service.user.data.User;

import static com.tomash.gombosh.api.service.ServiceConstant.NO_ERROR_MESSAGE;
import static java.util.Objects.nonNull;
import static java.util.Objects.requireNonNull;

/**
 * @author Tomash Gombosh
 * @since 1.0.0
 */
@Log4j2
public class UserService {
    private final ResponseProcessor responseProcessor;
    private final UserClient userClient;

    @Inject
    public UserService(final ResponseProcessor responseProcessor, final UserClient userClient) {
        this.responseProcessor = responseProcessor;
        this.userClient = userClient;
    }

    public User getUser(final String id) {
        requireNonNull(id, "User id can not be null");

        final CompletableFuture<User> userCompletableFuture = userClient.getUser(id);
        return userCompletableFuture.handle((result, throwable) -> {
            if (nonNull(result)) {
                log.info("Get user data with id {}", result.getId());
                return result;
            }
            final String errorMessage = responseProcessor.extractErrorMessage(throwable).orElse(NO_ERROR_MESSAGE);
            throw new ServiceException("Unable to get user data", errorMessage);
        }).join();
    }

    public User createUser(final User user) {
        requireNonNull(user, "User body can not be null");

        final CompletableFuture<User> userCompletableFuture = userClient.createUser(user);
        return userCompletableFuture.handle((result, throwable) -> {
            if (nonNull(result)) {
                log.info("Create user with id {}", result.getId());
                return result;
            }
            final String errorMessage = responseProcessor.extractErrorMessage(throwable).orElse(NO_ERROR_MESSAGE);
            throw new ServiceException("Unable to create user", errorMessage);
        }).join();
    }

    public User updateUserByPut(final String id, final User user) {
        requireNonNull(id, "User id can not be null");
        requireNonNull(user, "User body can not be null");

        final CompletableFuture<User> userCompletableFuture = userClient.putUser(id, user);
        return userCompletableFuture.handle((result, throwable) -> {
            if (nonNull(result)) {
                log.info("Update user by put with id {}", result.getId());
                return result;
            }
            final String errorMessage = responseProcessor.extractErrorMessage(throwable).orElse(NO_ERROR_MESSAGE);
            throw new ServiceException("Unable update user by put", errorMessage);
        }).join();
    }

    public User updateUserByPatch(final String id, final User user) {
        requireNonNull(id, "User id can not be null");
        requireNonNull(user, "User body can not be null");

        final CompletableFuture<User> userCompletableFuture = userClient.patchUser(id, user);
        return userCompletableFuture.handle((result, throwable) -> {
            if (nonNull(result)) {
                log.info("Update user by patch with id {}", result.getId());
                return result;
            }
            final String errorMessage = responseProcessor.extractErrorMessage(throwable).orElse(NO_ERROR_MESSAGE);
            throw new ServiceException("Unable update user by patch", errorMessage);
        }).join();
    }

    public User deleteUser(final String id) {
        requireNonNull(id, "User id can not be null");

        final CompletableFuture<User> userCompletableFuture = userClient.deleteUser(id);
        return userCompletableFuture.handle((result, throwable) -> {
            if (result == null) {
                log.info("Delete user with id {}", id);
                return result;
            }
            final String errorMessage = responseProcessor.extractErrorMessage(throwable).orElse(NO_ERROR_MESSAGE);
            throw new ServiceException("Unable delete user", errorMessage);
        }).join();
    }

}
