package com.github.teocci.javajpaspringgradle.repositories;

import com.github.teocci.javajpaspringgradle.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Long> {
}
