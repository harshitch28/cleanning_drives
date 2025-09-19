package com.cleanliness.drive.controller;

import com.cleanliness.drive.Entity.Drives;
import com.cleanliness.drive.dto.DriveAddRequest;
import com.cleanliness.drive.service.DrivesService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/drives")
public class DrivesController {
    private final DrivesService drivesService;

    public DrivesController(DrivesService drivesService) {
        this.drivesService = drivesService;
    }

    @PostMapping("/addDrive")
    public String addDrive(@RequestBody DriveAddRequest driveAddRequest){
        return drivesService.addDrive(driveAddRequest);
    }
    @GetMapping("/get-drive/{id}")
    public Drives getDriveById(@PathVariable long id){
        return drivesService.getDriveById(id);
    }
    @PatchMapping("/enroll-now/{id}")
    public String enrollInDrive(@PathVariable long id){
        return drivesService.enrollInDrive(id);
    }
}
