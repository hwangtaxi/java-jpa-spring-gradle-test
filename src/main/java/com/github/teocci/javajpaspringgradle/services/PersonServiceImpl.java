package com.github.teocci.javajpaspringgradle.services;

import com.github.teocci.javajpaspringgradle.models.Person;
import com.github.teocci.javajpaspringgradle.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class PersonServiceImpl implements PersonService {
    private final PersonRepository repository;
    public Person save(Person person) { return repository.save(person); }
    public List<Person> findAll() { return repository.findAll(); }
    public Person findById(Long id) { return repository.findById(id).orElse(null); }
    public void delete(Person person) { repository.delete(person); }
}