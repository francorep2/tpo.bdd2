package com.tpo.bdd2.tpo.bdd2.repository;

import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import com.tpo.bdd2.tpo.bdd2.model.Hotel;

@Repository
public interface HotelNeo4jRepository extends Neo4jRepository<Hotel, String> {

    void deleteAllHotelRoomsByid(String id);

    
   @Query("MATCH (h:Hotel)-[:HAS_POI]->(p:Poi) WHERE p.poiName = $poiName RETURN h.id")
   List<String> getAllHotelsIDByPoiName(String poiName);


    
}