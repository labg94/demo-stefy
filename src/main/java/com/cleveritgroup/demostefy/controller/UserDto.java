package com.cleveritgroup.demostefy.controller;

import com.cleveritgroup.demostefy.model.User;

public record UserDto(String id, String name, String lastName, String email, String password) {

    public User toDomain() {
        return new User(id, name, lastName, email, password);
    }


    public static UserDto fromDomain(User user) {
        return new UserDto(user.getId(), user.getName(), user.getLastName(), user.getEmail(), user.getPassword());
    }

}
