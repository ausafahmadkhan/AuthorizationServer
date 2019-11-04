package com.example.OAuthServer.Persistence.Repository;

import com.example.OAuthServer.Persistence.Models.UserDAO;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Optional;

public interface UserRepository extends MongoRepository<UserDAO, String>
{
    @Query("{'username' : ?0}")
    Optional<UserDAO> findUserByUserName(String username);
}
