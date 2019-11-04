package com.example.OAuthServer.Service;

import com.example.OAuthServer.Persistence.Models.UserDAO;
import com.example.OAuthServer.Persistence.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService
{
    @Autowired
    private UserRepository userRepository;

    UserDAO findUserByUserName(String name)
    {

        UserDAO userDAO = userRepository.findUserByUserName(name)
                .orElseThrow(() -> new UsernameNotFoundException("User not present"));

        return userDAO;
    }
}
