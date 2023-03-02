package com.github.teocci.javajpaspringgradle.controllers;

import com.github.teocci.javajpaspringgradle.exceptions.ResourceNotFoundException;
import com.github.teocci.javajpaspringgradle.models.User;
import com.github.teocci.javajpaspringgradle.services.UserServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    private final UserServiceImpl userService;

    public UserController(UserServiceImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/list")
    public List<User> getAllUser() {
        return userService.findAll();
    }

    @GetMapping("/list/{id}")
    public List<User> getUserByIdList(@PathVariable(value = "id") Long userId) {
        List<User> user = new ArrayList<>();
        user.add(userService.findById(userId));
        return user;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long UserId)
            throws ResourceNotFoundException {
        User User = userService.findById(UserId);
        return ResponseEntity.ok().body(User);
    }

    @PostMapping("")
    public User createUser(@Valid User User) {
        return userService.save(User);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable(value = "id") Long userId,
                                               @RequestParam String name, @RequestParam String email, @RequestParam String password) throws ResourceNotFoundException {
        User user = userService.findById(userId);

        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        final User updatedUser = userService.save(user);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteUser(@PathVariable(value = "id") Long userId)
            throws ResourceNotFoundException {
        User user = userService.findById(userId);

        userService.delete(user);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}