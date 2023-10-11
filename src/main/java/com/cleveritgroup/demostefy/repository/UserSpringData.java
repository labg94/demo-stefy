package com.cleveritgroup.demostefy.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface UserSpringData extends MongoRepository<UserMongoDto,String> {

    Optional<UserMongoDto> findByEmail(String email);

    void deleteByEmail(String email);
}
