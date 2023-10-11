package com.cleveritgroup.demostefy.repository;

import com.cleveritgroup.demostefy.model.User;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public record UserMongoDto(@Id String id,String name, String lastName, String email, String password) {

    public User toDomain() {
        return new User(id,name, lastName, email, password);
    }

    public static UserMongoDto fromDomain(User user) {
        return new UserMongoDto(null,user.getName(), user.getLastName(), user.getEmail(), user.getPassword());
    }

}
