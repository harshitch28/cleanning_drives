package com.cleanliness.drive.service;

import com.cleanliness.drive.Entity.Users;
import com.cleanliness.drive.dto.LoginRequest;
import com.cleanliness.drive.dto.RegisterRequest;
import com.cleanliness.drive.repository.UsersRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterService {

    private final UsersRepository usersRepository;
    private final PasswordEncoder passwordEncoder;

    public RegisterService(UsersRepository usersRepository,PasswordEncoder passwordEncoder) {
        this.usersRepository = usersRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String register(RegisterRequest request) {
        if(usersRepository.findByEmail(request.getEmail()) != null){
            return "Email already exists!";
        }
        Users user = new Users();
        user.setEmail(request.getEmail());
        user.setUsername(request.getUsername());
        user.setPassword(passwordEncoder.encode(request.getPassword()));
        user.setRoles("ROLES_USER");
        usersRepository.save(user);
        return "USER registered successfully";
    }
}
