package com.example.springbootjpa.controller;

import com.example.springbootjpa.model.dto.UserRequest;
import com.example.springbootjpa.model.dto.UserResponse;
import com.example.springbootjpa.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUser(@PathVariable Long id) {
        return ResponseEntity.ok().body(userService.getUser(id));
    }

    @PostMapping
    public ResponseEntity<UserResponse> addUser(@RequestBody UserRequest dto) {
        return ResponseEntity.ok().body(userService.addUser(dto));
    }
}
