package com.cleanliness.drive.controller;

import com.cleanliness.drive.Entity.Drives;
import com.cleanliness.drive.Entity.Users;
import com.cleanliness.drive.service.UsersService;
import com.cleanliness.drive.util.CurrentUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {
    private final UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping("/mydrives")
    public List<Drives> myDrives(){
        return usersService.getMyDrives();
    }
}
