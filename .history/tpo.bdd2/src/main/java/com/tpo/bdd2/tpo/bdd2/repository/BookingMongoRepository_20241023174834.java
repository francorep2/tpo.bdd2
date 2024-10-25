package com.tpo.bdd2.tpo.bdd2.repository;

public class BookingMongoRepository {

}
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface BookingMongoRepository extends MongoRepository<Client, Long> {
    // Puedes agregar métodos personalizados aquí si es necesario
}
