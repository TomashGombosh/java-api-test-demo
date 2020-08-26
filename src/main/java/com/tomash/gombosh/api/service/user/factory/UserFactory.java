package com.tomash.gombosh.api.service.user.factory;

import java.util.Locale;

import com.devskiller.jfairy.Fairy;
import com.tomash.gombosh.api.service.Factory;
import com.tomash.gombosh.api.service.user.data.User;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author Tomash Gombosh
 */
@Setter
@Accessors(chain = true)
public class UserFactory implements Factory<User, UserFactory> {
    private static final Fairy FAIRY = Fairy.create(Locale.US);
    private String name = null;
    private String job = null;

    @Override
    public User create() {
        final String userName = name != null ? name : FAIRY.person().getFirstName();
        final String userJob = job != null ? job : FAIRY.person().getCompany().getName();
        return new User(user -> {
            user.setName(userName);
            user.setJob(userJob);
        });
    }
}
