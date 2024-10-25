package com.tpo.bdd2.tpo.bdd2.repositorymport org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.tpo.bdd2.tpo.bdd2.model.Client;

@Repository
public interface ClientNeo4jRepository extends Neo4jRepository<Client, Long> {
    
}