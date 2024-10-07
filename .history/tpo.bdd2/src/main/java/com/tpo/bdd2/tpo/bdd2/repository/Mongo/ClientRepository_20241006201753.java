package com.tpo.bdd2.tpo.bdd2.repository.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tpo.bdd2.tpo.bdd2.model.Hotel;

@Repository
public interface ClientRepository extends MongoRepository<Client, String> {
    
}
