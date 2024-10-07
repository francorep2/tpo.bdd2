package com.tpo.bdd2.tpo.bdd2.repository.mongo;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tpo.bdd2.tpo.bdd2.model.Client;

@Repository
public interface ClientRepository extends MongoRepository<Client, Long> {
    
    @SuppressWarnings("null")
    Optional<Client> findByID(Long id);
}
