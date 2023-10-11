package com.cleveritgroup.demostefy.controller;

import com.cleveritgroup.demostefy.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.findAll().stream().map(UserDto::fromDomain).toList();
    }

    @PostMapping
    public UserDto createUser(@RequestBody  UserDto userDto) {
        return UserDto.fromDomain(userService.save(userDto.toDomain()));
    }


    @GetMapping("{email}")
    public UserDto getUserByEmail(@PathVariable String email) {
        return UserDto.fromDomain(userService.findByEmail(email));
    }

    @PutMapping
    public UserDto updateUser(UserDto userDto) {
        return UserDto.fromDomain(userService.update(userDto.toDomain()));
    }

    @DeleteMapping("{email}")
    public void deleteUser(@RequestBody UserDto userDto) {
        userService.delete(userDto.toDomain());
    }


}
