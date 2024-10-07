package com.tpo.bdd2.tpo.bdd2.repository.neo4j;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.tpo.bdd2.tpo.bdd2.model.Booking;

@Repository
public interface RoomNeo4jRepository extends Neo4jRepository<Booking, Long> {
    
}

