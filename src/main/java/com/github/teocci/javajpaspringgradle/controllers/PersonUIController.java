package com.github.teocci.javajpaspringgradle.controllers;

import com.github.teocci.javajpaspringgradle.exceptions.ResourceNotFoundException;
import com.github.teocci.javajpaspringgradle.models.Person;
import com.github.teocci.javajpaspringgradle.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;


@Controller
@RequestMapping("/person")
public class PersonUIController {
    @Autowired
    private final PersonRepository repository;

    public PersonUIController(PersonRepository personRepository) {
        this.repository = personRepository;
    }

    @GetMapping("/list")
    public String getAllPerson(Model model) throws IOException {
        model.addAttribute("data", repository.findAll());
        return "person/tablePerson";
    }


    @GetMapping("/get/{id}")
    public String getPersonById(@PathVariable(value = "id") Long personId, Model model) throws ResourceNotFoundException {
        Person person = repository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found for this id :: " + personId));
        model.addAttribute("data", person);
        return "person/getPerson";
    }

    @GetMapping("/add")
    public String createPerson() {
        return "person/addPerson";
    }


    @GetMapping("/mod/{id}")
    public String updatePerson(@PathVariable(value = "id") Long personId, Model model) throws ResourceNotFoundException {
        Person person = repository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found for this id :: " + personId));
        model.addAttribute("data", person);
        return "person/modPerson";
    }

    @GetMapping("/del/{id}")
    public String deletePerson(@PathVariable(value = "id") Long personId, Model model) throws ResourceNotFoundException {
        Person person = repository.findById(personId)
                .orElseThrow(() -> new ResourceNotFoundException("Person not found for this id :: " + personId));
        model.addAttribute("data", person);
        return "person/delPerson";
    }
}

