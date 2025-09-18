package com.cleanliness.drive.config;

import com.cleanliness.drive.Entity.Users;
import com.cleanliness.drive.repository.UsersRepository;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.stream.Collectors;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    private final UsersRepository usersRepository;

    public CustomUserDetailsService(UsersRepository usersRepository){
        this.usersRepository = usersRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Users user = usersRepository.findByEmail(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found");
        }


        return new User(user.getEmail(), user.getPassword(),
                        Arrays.stream(user.getRoles().split(","))
                                .map(SimpleGrantedAuthority::new)
                                .collect(Collectors.toList())
        );

    }
}
