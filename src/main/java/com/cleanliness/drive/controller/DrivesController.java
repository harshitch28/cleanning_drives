package com.cleanliness.drive.controller;

import com.cleanliness.drive.dto.DriveAddRequest;
import com.cleanliness.drive.service.DrivesService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
