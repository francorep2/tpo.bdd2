package com.tpo.bdd2.tpo.bdd2.repository;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tpo.bdd2.tpo.bdd2.model.Client;

@Repository
public interface ClientNeo4jRepository extends Neo4jRepository<Client, String> {

    @Query("MATCH (c:Client {id: $id})-[r:LIVES_IN]->(a:Address) DETACH DELETE c, a, r")
    void removeClientAndAddressByid(@Param("id") String id);

   
}