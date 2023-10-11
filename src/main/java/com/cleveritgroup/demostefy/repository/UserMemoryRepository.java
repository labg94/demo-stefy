package com.cleveritgroup.demostefy.repository;

import com.cleveritgroup.demostefy.model.User;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
@Profile("memory")
public class UserMemoryRepository implements UserRepository {

    public List<User> users = new ArrayList<>();

    @Override
    public User save(User user) {
        users.add(user);
        return user;
    }

    @Override
    public void delete(String email) {
        users.removeIf(user -> user.getEmail().equals(email));
    }

    @Override
    public User update(User user) {
        users =
                users.stream().map(u -> {
                            if (u.getEmail().equals(user.getEmail())) {
                                return user;
                            }
                            return u;
                        })
                        .toList();

        return user;
    }

    @Override
    public User findByEmail(String email) {
        return users.stream().filter(user -> user.getEmail().equals(email)).findFirst().orElse(null);
    }

    @Override
    public List<User> findAll() {
        return users;
    }
}
