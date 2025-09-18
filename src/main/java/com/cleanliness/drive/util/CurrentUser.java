package com.cleanliness.drive.util;

import com.cleanliness.drive.Entity.Users;
import com.cleanliness.drive.repository.UsersRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

public class CurrentUser {

    public static String getCurrentUsername(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        return authentication.getName();
    }
}
