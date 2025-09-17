package com.cleanliness.drive.controller;

import com.cleanliness.drive.Entity.Drives;
import com.cleanliness.drive.service.DrivesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
public class DashboardController {

    private final DrivesService drivesService;

    public DashboardController(DrivesService drivesService) {
        this.drivesService = drivesService;
    }

    @GetMapping("/allDrives")
    public List<Drives> listAllDrives(){
        return drivesService.getAllDrives();
    }
}
