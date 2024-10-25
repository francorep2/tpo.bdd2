package com.tpo.bdd2.tpo.bdd2.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tpo.bdd2.tpo.bdd2.model.Booking;

@Repository
public interface BookingMongoRepository extends MongoRepository<Booking, Long> {



    
}
