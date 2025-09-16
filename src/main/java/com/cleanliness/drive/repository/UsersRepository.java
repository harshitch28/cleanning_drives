package com.cleanliness.drive.repository;

import com.cleanliness.drive.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users,Long> {
    Optional<Object> findByUsername(String username);
}
