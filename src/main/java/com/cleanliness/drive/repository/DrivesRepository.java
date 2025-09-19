package com.cleanliness.drive.repository;

import com.cleanliness.drive.Entity.Drives;
import com.cleanliness.drive.Entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface DrivesRepository extends JpaRepository<Drives,Long> {
    @Transactional
    @Modifying
    @Query("update Drives d set d.enrolled = ?1 where d.id = ?2")
    void updateEnrolledById(List<Users> enrolled, long id);
}
