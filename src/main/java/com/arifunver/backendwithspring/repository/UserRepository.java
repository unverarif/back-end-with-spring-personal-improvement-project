package com.arifunver.backendwithspring.repository;

import com.arifunver.backendwithspring.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
