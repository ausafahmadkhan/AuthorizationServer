package com.example.OAuthServer.Persistence.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Document(value = "Clients")
public class ClientDAO
{
    @Id
    private String clientId;
    private String clientSecret;
    private Set<String> authorizedGrantType;
    private Set<String> clientScope;
    private boolean autoApprove;
}
