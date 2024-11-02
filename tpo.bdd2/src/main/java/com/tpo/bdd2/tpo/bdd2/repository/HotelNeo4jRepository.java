package com.tpo.bdd2.tpo.bdd2.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tpo.bdd2.tpo.bdd2.domain.PoiDTO;
import com.tpo.bdd2.tpo.bdd2.model.Hotel;

@Repository
public interface HotelNeo4jRepository extends Neo4jRepository<Hotel, String> {

    @Query("MATCH (h:Hotel)-[:HAS_POI]->(p:Poi) WHERE p.poiName = $poiName RETURN h")
    List<Hotel> findHotelsByPOI(@Param("poiName") String poiName);

    @Query("MATCH (h:Hotel)-[:HAS_POI]->(p:POI) WHERE ID(h) = $id RETURN p")
    List<PoiDTO> getAllPOISinHotelByid(@Param("id") String id);

    void deleteAllHotelRoomsByid(String id);


    
}