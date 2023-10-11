package com.cleveritgroup.demostefy.service;

import com.cleveritgroup.demostefy.model.User;

import java.util.List;

public interface UserService {

    User save(User user);
    void delete(User user);
    User update(User user);
    User findByEmail(String email);


    List<User> findAll();
}
