package com.tpo.bdd2.tpo.bdd2.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.tpo.bdd2.tpo.bdd2.model.Hotel;

@Repository
public interface HotelNeo4jRepository extends Neo4jRepository<Hotel, Long> {

    @Query("MATCH (h:Hotel) WHERE h.poi.name = $poiName RETURN h")
    ListHotel findHotelsByPOI((@Param("poiName")String poiName);    
    
}