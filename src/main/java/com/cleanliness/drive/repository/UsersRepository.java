package com.cleanliness.drive.repository;

import com.cleanliness.drive.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Users,Long> {
    Users findByUsername(String username);
    boolean existsByUsername(String username);
}
