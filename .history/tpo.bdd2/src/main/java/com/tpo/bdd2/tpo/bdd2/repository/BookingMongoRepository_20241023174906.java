package com.tpo.bdd2.tpo.bdd2.repository;

import org.springframework.data.mongodb.*;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.tpo.bdd2.tpo.bdd2.model.Booking;

public interface BookingMongoRepository extends MongoRepository<Booking, Long> {
    // Puedes agregar métodos personalizados aquí si es necesario
}
