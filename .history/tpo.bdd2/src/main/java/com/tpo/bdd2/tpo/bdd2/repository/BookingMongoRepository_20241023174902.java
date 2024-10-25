package com.tpo.bdd2.tpo.bdd2.repository;

import org.springframework.data.mongodb.*;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookingMongoRepository extends MongoRepository<Client, Long> {
    // Puedes agregar métodos personalizados aquí si es necesario
}
