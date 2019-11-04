package com.example.OAuthServer.Persistence.Repository;

import com.example.OAuthServer.Persistence.Models.ClientDAO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface ClientRepository extends MongoRepository<ClientDAO, String>
{
    @Query("{'clientId' : ?0}")
    Optional<ClientDAO> findClientByClientId(String clientId);
}
