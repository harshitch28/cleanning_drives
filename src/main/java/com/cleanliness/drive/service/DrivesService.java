package com.cleanliness.drive.service;

import com.cleanliness.drive.Entity.Drives;
import com.cleanliness.drive.Entity.Users;
import com.cleanliness.drive.dto.DriveAddRequest;
import com.cleanliness.drive.repository.DrivesRepository;
import com.cleanliness.drive.repository.UsersRepository;
import com.cleanliness.drive.util.CurrentUser;
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

    public Drives getDriveById(long id) {
        return drivesRepository.getReferenceById(id);
    }

    public String enrollInDrive(long id) {
        Drives drives = drivesRepository.getReferenceById(id);
        List<Users> userList = drives.getEnrolled();
        String username = CurrentUser.getCurrentUsername();
        Users currUser = usersRepository.findByEmail(username);
        userList.add(currUser);
        List<Drives> userEnrolledDriveList = currUser.getEnrolledIn();
        userEnrolledDriveList.add(drives);
        drivesRepository.updateEnrolledById(userList,id);
        usersRepository.updateEnrolledInByUsername(userEnrolledDriveList,username);
        return "Enrolled in Drive Successfully";
    }
}
