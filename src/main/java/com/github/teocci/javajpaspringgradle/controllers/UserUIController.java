package com.github.teocci.javajpaspringgradle.controllers;

import com.github.teocci.javajpaspringgradle.exceptions.ResourceNotFoundException;
import com.github.teocci.javajpaspringgradle.models.User;
import com.github.teocci.javajpaspringgradle.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;


@Controller
@RequestMapping("/user")
public class UserUIController {
    @Autowired
    private final UserRepository repository;

    public UserUIController(UserRepository userRepository) {
        this.repository = userRepository;
    }

    @GetMapping("/list")
    public String getAllUser(Model model) throws IOException {
        model.addAttribute("data", repository.findAll());
        return "user/tableUser";
    }


    @GetMapping("/get/{id}")
    public String getUserById(@PathVariable(value = "id") Long userId, Model model) throws ResourceNotFoundException {
        User user = repository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
        model.addAttribute("data", user);
        return "user/getUser";
    }

    @GetMapping("/add")
    public String createUser() {
        return "user/addUser";
    }


    @GetMapping("/mod/{id}")
    public String updateUser(@PathVariable(value = "id") Long userId, Model model) throws ResourceNotFoundException {
        User user = repository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
        model.addAttribute("data", user);
        return "user/modUser";
    }

    @GetMapping("/del/{id}")
    public String deleteUser(@PathVariable(value = "id") Long userId, Model model) throws ResourceNotFoundException {
        User user = repository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found for this id :: " + userId));
        model.addAttribute("data", user);
        return "user/delUser";
    }
}
