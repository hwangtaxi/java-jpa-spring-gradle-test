package com.github.teocci.javajpaspringgradle.services;

import com.github.teocci.javajpaspringgradle.models.User;
import com.github.teocci.javajpaspringgradle.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService{
    private final UserRepository repository;
    public User save(User user) { return repository.save(user); }
    public List<User> findAll() { return repository.findAll(); }
    public User findById(Long id) { return repository.findById(id).orElse(null); }
    public void delete(User user) { repository.delete(user); }
}
