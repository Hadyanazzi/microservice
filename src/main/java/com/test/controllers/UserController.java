package com.test.controllers;


import com.test.entities.User;
import com.test.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

//    @PostMapping
//    public ResponseEntity<RegisterLoginResponseDto> createUser(@RequestBody RegisterRequestCommand registerRequestCommand) {
//        RegisterLoginResponseDto user = userService.register(registerRequestCommand);
//        return ResponseEntity.status(HttpStatus.CREATED).body(user);
//    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        List<User> userList = userService.getAllUsers();
        return ResponseEntity.ok(userList);
    }
}