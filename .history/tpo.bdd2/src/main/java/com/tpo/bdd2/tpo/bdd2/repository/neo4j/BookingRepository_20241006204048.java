package com.tpo.bdd2.tpo.bdd2.repository.mongo;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tpo.bdd2.tpo.bdd2.model.Booking;

@Repository
public interface BookingNeo4jRepository extends MongoRepository<Booking, Long> {
    
}

