package com.cleveritgroup.demostefy.repository;

import com.cleveritgroup.demostefy.model.User;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Profile("!memory")
public class UserMongoRepository implements UserRepository {
    private final UserSpringData userSpringData;

    public UserMongoRepository(UserSpringData userSpringData) {
        this.userSpringData = userSpringData;
    }

    @Override
    public User save(User user) {
        return userSpringData.save(UserMongoDto.fromDomain(user)).toDomain();
    }

    @Override
    public void delete(String email) {
        userSpringData.deleteByEmail(email);
    }

    @Override
    public User update(User user) {
        return userSpringData.save(UserMongoDto.fromDomain(user)).toDomain();
    }

    @Override
    public User findByEmail(String email) {
        return userSpringData.findByEmail(email).map(UserMongoDto::toDomain).orElse(null);
    }

    @Override
    public List<User> findAll() {
        return userSpringData.findAll().stream().map(UserMongoDto::toDomain).toList();
    }
}
