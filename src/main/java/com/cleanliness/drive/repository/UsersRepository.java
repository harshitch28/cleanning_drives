package com.cleanliness.drive.repository;

import com.cleanliness.drive.Entity.Drives;
import com.cleanliness.drive.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface UsersRepository extends JpaRepository<Users,Long> {

    boolean existsByEmail(String username);

    Users findByEmail(String username);

    @Transactional
    @Modifying
    @Query("update Users u set u.enrolledIn = ?1 where u.username = ?2")
    int updateEnrolledInByUsername(List<Drives> enrolledIn, String username);
}
