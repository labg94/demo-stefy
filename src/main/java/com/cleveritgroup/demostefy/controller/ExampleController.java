package com.cleveritgroup.demostefy.controller;


import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/example")
public class ExampleController {

    @GetMapping
    public String getExample() {
        return "Hello World";
    }

    @GetMapping("{name}")
    //@PathVariable is used to get the value of a path variable from the URI
    public String getExampleWithName(@PathVariable String name) {
        return "Hello " + name;
    }

//    @PostMapping
//    //@RequestBody is used to get the value of a request body
//    public String postExample(@RequestBody UserDto body) {
//        return "Hello " + body;
//    }
}
