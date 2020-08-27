package com.tomash.gombosh.api;

import java.time.ZonedDateTime;
import javax.inject.Inject;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.tomash.gombosh.api.service.user.UserService;
import com.tomash.gombosh.api.service.user.data.User;
import com.tomash.gombosh.api.service.user.factory.UserFactory;

/**
 * @author Tomash Gombosh
 */
@DisplayName("User Test")
class UserTests extends BaseTest {
    @Inject
    private UserService userService;

    @Test
    @DisplayName("Create an user")
    void createAnUser() {
        final User newUser = new UserFactory().create();
        final User createdUser = userService.createUser(newUser);
        assertThat(createdUser)
                .as("Created user can not be null")
                .isNotNull();
        assertThat(newUser.equals(createdUser))
                .as("User data should be the same")
                .isEqualTo(true);
    }

    @Test
    @DisplayName("Get an user")
    void getAnUser() {
        final User createdUser = userService.getUser("2");
        assertThat(createdUser)
                .as("Get user can not be null")
                .isNotNull();
    }

    @Test
    @DisplayName("Update an user by put")
    void updateAnUserByPut() {
        final User newUser = new UserFactory().create();
        final User updateUserByPut = userService.updateUserByPut("12", newUser);
        assertThat(updateUserByPut)
                .as("Updated user can not be null")
                .isNotNull();
        assertThat(updateUserByPut.getUpdatedAt())
                .as("Updated user date can not be null")
                .isNotNull();
        assertThat(updateUserByPut.getUpdatedAt())
                .isNotIn(ZonedDateTime.now().plusSeconds(5));
    }

    @Test
    @DisplayName("Update an user by patch")
    void updateAnUserByPatch() {
        final User newUser = new UserFactory().create();
        final User updateUserByPatch = userService.updateUserByPatch("12", newUser);
        assertThat(updateUserByPatch)
                .as("Updated user can not be null")
                .isNotNull();
        assertThat(updateUserByPatch.getUpdatedAt())
                .as("Updated user date can not be null")
                .isNotNull();
        assertThat(updateUserByPatch.getUpdatedAt())
                .isNotIn(ZonedDateTime.now().plusSeconds(5));
    }

    @Test
    @DisplayName("Delete user")
    void deleteUser() {
        final User deleteUser = userService.deleteUser("12");
        assertThat(deleteUser)
                .as("User should be deleted")
                .isNull();
    }
}
