package com.cleanliness.drive.service;

import com.cleanliness.drive.Entity.Drives;
import com.cleanliness.drive.dto.DriveAddRequest;
import com.cleanliness.drive.repository.DrivesRepository;
import com.cleanliness.drive.repository.UsersRepository;
import com.cleanliness.drive.util.CurrentUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrivesService {

    private final DrivesRepository drivesRepository;
    private final UsersRepository usersRepository;

    public DrivesService(DrivesRepository drivesRepository,
                         UsersRepository usersRepository) {
        this.drivesRepository = drivesRepository;
        this.usersRepository = usersRepository;
    }

    public List<Drives> getAllDrives(){
        return drivesRepository.findAll();
    }

    public String addDrive(DriveAddRequest driveAddRequest) {
        String username = CurrentUser.getCurrentUsername();
        Drives drives = new Drives();
        drives.setDescription(driveAddRequest.getDescription());
        drives.setName(driveAddRequest.getName());
        drives.setStatus(driveAddRequest.getStatus());
        drives.setCreator(usersRepository.findByEmail(username));
        drivesRepository.save(drives);
        return "Drive added successfully";
    }
}
