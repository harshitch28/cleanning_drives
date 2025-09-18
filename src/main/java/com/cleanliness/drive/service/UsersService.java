package com.cleanliness.drive.service;

import com.cleanliness.drive.Entity.Drives;
import com.cleanliness.drive.repository.UsersRepository;
import com.cleanliness.drive.util.CurrentUser;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService {

    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public List<Drives> getMyDrives() {
        String username = CurrentUser.getCurrentUsername();
        return usersRepository.findByEmail(username).getDrivesList();
    }
}
