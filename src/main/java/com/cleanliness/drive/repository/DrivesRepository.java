package com.cleanliness.drive.repository;

import com.cleanliness.drive.Entity.Drives;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DrivesRepository extends JpaRepository<Drives,Long> {
}
