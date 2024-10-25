package com.tpo.bdd2.tpo.bdd2.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.tpo.bdd2.tpo.bdd2.domain.RoomDTO;
import com.tpo.bdd2.tpo.bdd2.model.Hotel;
import com.tpo.bdd2.tpo.bdd2.model.Room;
import.

@Repository
public interface RoomNeo4jRepository extends Neo4jRepository<Room, Long> {

    
    List<RoomDTO> findRoomByDateRange(LocalDate startDate, LocalDate endDate)


}

