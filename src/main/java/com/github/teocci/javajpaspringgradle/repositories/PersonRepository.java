package com.github.teocci.javajpaspringgradle.repositories;

import com.github.teocci.javajpaspringgradle.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PersonRepository extends JpaRepository<Person, Long> {
}