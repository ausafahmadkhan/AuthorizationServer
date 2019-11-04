package com.example.OAuthServer.Service;

import com.example.OAuthServer.Persistence.Models.MyUserDetails;
import com.example.OAuthServer.Persistence.Models.UserDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class MyUserDetailsService implements UserDetailsService
{
    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        UserDAO userDAO = userService.findUserByUserName(s);
        MyUserDetails userDetails = new MyUserDetails(userDAO);
        return userDetails;
    }
}
