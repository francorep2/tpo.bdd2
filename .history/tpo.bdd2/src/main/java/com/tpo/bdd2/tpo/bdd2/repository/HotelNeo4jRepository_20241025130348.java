package com.tpo.bdd2.tpo.bdd2.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tpo.bdd2.tpo.bdd2.model.Hotel;

@Repository
public interface HotelNeo4jRepository extends Neo4jRepository<Hotel, Long> {

    @Query("MATCH (h:Hotel)-[:HAS_POI]->(p:POI) WHERE p.name = $poiName RETURN h")
    List<Hotel> findHotelsByPOI(@Param("poiName") String poiName);  

    @Query()
    List<String> getAllPoiInHotel(@Param("hotelId")Long hotelId) ;
    
}