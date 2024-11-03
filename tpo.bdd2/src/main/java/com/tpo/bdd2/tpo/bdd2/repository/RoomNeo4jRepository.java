package com.tpo.bdd2.tpo.bdd2.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tpo.bdd2.tpo.bdd2.model.Room;

@Repository
public interface RoomNeo4jRepository extends Neo4jRepository<Room, String> {

    @Query("""
        MATCH (ro:Room)<-[r:HAS-ROOM]-(h:Hotel)
        WHERE r.isAvaible = true
        AND r.availableFrom <= $startDate
        AND r.availableUntil >= $endDate
        RETURN ro,r,h
    """)
    List<Room> findRoomByDateRange(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);

    
}

