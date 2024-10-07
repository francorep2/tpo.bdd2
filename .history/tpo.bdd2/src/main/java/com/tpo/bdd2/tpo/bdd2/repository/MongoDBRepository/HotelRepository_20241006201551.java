package com.tpo.bdd2.tpo.bdd2.repository.MongoDBRepository;

package com.tpo.bdd2.tpo.bdd2.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tpo.bdd2.tpo.bdd2.model.Hotel;

@Repository
public interface HotelRepository extends MongoRepository<Hotel, String> {
    // Puedes agregar consultas personalizadas si es necesario
    Hotel findByName(String name);
}
