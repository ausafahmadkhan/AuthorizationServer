package com.example.OAuthServer.Service;

import com.example.OAuthServer.Persistence.Models.ClientDAO;
import com.example.OAuthServer.Persistence.Models.MyClientDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.provider.ClientDetails;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.ClientRegistrationException;
import org.springframework.stereotype.Service;

@Service
public class MyClientDetailsService implements ClientDetailsService
{
    @Autowired
    private ClientService clientService;

    @Override
    public ClientDetails loadClientByClientId(String s) throws ClientRegistrationException
    {
        ClientDAO clientDAO = clientService.findClientById(s);
        MyClientDetails myClientDetails = new MyClientDetails(clientDAO);
        return myClientDetails;
    }
}
