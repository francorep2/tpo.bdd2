package com.tpo.bdd2.tpo.bdd2.repository;

import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

import com.tpo.bdd2.tpo.bdd2.model.Poi;

@Repository
public interface PoiNeo4jRepository extends Neo4jRepository<Poi, String> {


}
