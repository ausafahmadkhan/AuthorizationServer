package com.example.OAuthServer.Persistence.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document("Users")
public class UserDAO
{
    @Id
    private String id;
    private String username;
    private String password;
    private String email;
    private boolean isActive;
    private List<Role> roles;
}
