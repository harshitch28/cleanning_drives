package com.cleanliness.drive.controller;

import com.cleanliness.drive.dto.AuthRequest;
import com.cleanliness.drive.service.RegisterService;
import com.cleanliness.drive.util.JwtUtil;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;
    private RegisterService registerService;
    
    public AuthController(AuthenticationManager authManager, JwtUtil jwtUtil, UserDetailsService userDetailsService,RegisterService registerService){
        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
        this.userDetailsService = userDetailsService;
        this.registerService = registerService;
    }
    
    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request){
        authManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername() ,request.getPassword()));
        final UserDetails userDetails = userDetailsService.loadUserByUsername(request.getUsername());
        final String token = jwtUtil.generateToken(userDetails.getUsername());
        return token;
    }

    @PostMapping("/register")
    public String register(@RequestBody AuthRequest request){
        return registerService.register(request);
    }
}
