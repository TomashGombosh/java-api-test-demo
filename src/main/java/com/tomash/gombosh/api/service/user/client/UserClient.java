package com.tomash.gombosh.api.service.user.client;

import java.util.concurrent.CompletableFuture;

import com.tomash.gombosh.api.service.user.data.User;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * @author Tomash Gombosh
 */
public interface UserClient {

    @GET("/api/users/{id}")
    CompletableFuture<User> getUser(@Path("id") String id);

    @POST("/api/users")
    CompletableFuture<User> createUser(@Body User user);

    @PUT("/api/users/{id}")
    CompletableFuture<User> putUser(@Path("id") String id, @Body User user);

    @PATCH("/api/users/{id}")
    CompletableFuture<User> patchUser(@Path("id") String id, @Body User user);

    @DELETE("/api/users/{id}")
    CompletableFuture<User> deleteUser(@Path("id") String id);
}
