package com.github.teocci.javajpaspringgradle.controllers;

import com.github.teocci.javajpaspringgradle.exceptions.ResourceNotFoundException;
import com.github.teocci.javajpaspringgradle.models.Person;
import com.github.teocci.javajpaspringgradle.services.PersonServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/person")
public class PersonController {
    private final PersonServiceImpl personService;

    public PersonController(PersonServiceImpl personService) {
        this.personService = personService;
    }

    @GetMapping("/list")
    public List<Person> getAllPerson() {
        return personService.findAll();
    }

    @GetMapping("/list/{id}")
    public List<Person> getPersonByIdList(@PathVariable(value = "id") Long personId) {
        List<Person> person = new ArrayList<>();
        person.add(personService.findById(personId));
        return person;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPersonById(@PathVariable(value = "id") Long personId)
            throws ResourceNotFoundException {
        Person person = personService.findById(personId);
        return ResponseEntity.ok().body(person);
    }

    @PostMapping("")
    public Person createPerson(@Valid Person person) {
        return personService.save(person);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Person> updatePerson(@PathVariable(value = "id") Long personId,
                                               @RequestParam String name) throws ResourceNotFoundException {
        Person person = personService.findById(personId);

        person.setName(name);
        final Person updatedPerson = personService.save(person);
        return ResponseEntity.ok(updatedPerson);
    }

    @DeleteMapping("/{id}")
    public Map<String, Boolean> deletePerson(@PathVariable(value = "id") Long personId)
            throws ResourceNotFoundException {
        Person person = personService.findById(personId);

        personService.delete(person);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}