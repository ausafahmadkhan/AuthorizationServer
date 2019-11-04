package com.example.OAuthServer.Service;

import com.example.OAuthServer.Persistence.Models.ClientDAO;
import com.example.OAuthServer.Persistence.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ClientService
{
    @Autowired
    private ClientRepository clientRepository;

    public ClientDAO findClientById(String id)
    {
        ClientDAO clientDAO = clientRepository.findClientByClientId(id)
                .orElseThrow(() -> new UsernameNotFoundException("Client not registered"));
        return clientDAO;
    }
}
