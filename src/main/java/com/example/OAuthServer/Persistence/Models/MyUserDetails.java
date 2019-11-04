package com.example.OAuthServer.Persistence.Models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MyUserDetails extends UserDAO implements UserDetails
{
    private List<GrantedAuthority> authorityList;

    public MyUserDetails(UserDAO userDAO) {
        this.setUsername(userDAO.getUsername());
        this.setPassword(userDAO.getPassword());
        this.setEmail(userDAO.getEmail());
        this.setActive(userDAO.isActive());
        this.authorityList = new ArrayList<>();
        userDAO.getRoles()
                .forEach(role ->
                {
                    role.getPermissions()
                            .forEach(permission ->
                                    {
                                            this.authorityList.add(new SimpleGrantedAuthority(permission.getVal()));
                                    }
                            );
                });
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorityList;
    }

    @Override
    public boolean isAccountNonExpired() {
        return this.isActive();
    }

    @Override
    public boolean isAccountNonLocked() {
        return this.isActive();
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return this.isActive();
    }

    @Override
    public boolean isEnabled() {
        return this.isActive();
    }
}
