package com.cleveritgroup.demostefy.repository;

import com.cleveritgroup.demostefy.model.User;

import java.util.List;

public interface UserRepository {

    User save(User user);
    void delete(String email);
    User update(User user);
    User findByEmail(String email);


    List<User> findAll();

}
