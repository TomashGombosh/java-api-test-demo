package com.tomash.gombosh.api.service.user.data;

import java.time.ZonedDateTime;
import java.util.Objects;
import java.util.function.Consumer;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

import static java.util.Objects.requireNonNull;

/**
 * @author Tomash Gombosh
 */
@Data
public class User {
    @SerializedName("id")
    private String id;
    @SerializedName("name")
    private String name;
    @SerializedName("job")
    private String job;
    @SerializedName("updatedAt")
    private ZonedDateTime updatedAt;

    @Override
    public boolean equals(final Object object) {
        if (object == null || getClass() != object.getClass()) {
            return false;
        }
        final User user = (User) object;
        return Objects.equals(name, user.name)
                && Objects.equals(job, user.job);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, job);
    }

    public User(final Consumer<User> builder) {
        requireNonNull(builder).accept(this);
    }
}
