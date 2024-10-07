package com.tpo.bdd2.tpo.bdd2.repository.mongo;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.tpo.bdd2.tpo.bdd2.model.Booking;

@Repository
public interface BookingNeo4jRepository extends Neo4jRepository<Booking, Long> {
    
}