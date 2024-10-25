package com.tpo.bdd2.tpo.bdd2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.core.Neo4jClient;

@Configuration
public class Neo4jConfig {

    @Bean
    public Neo4jClient neo4jClient() {
        return Neo4jClient.create("bolt://localhost:7687"); // Cambia la URL según tu configuración
    }

    @Bean
    public Neo4jTemplate neo4jTemplate(Neo4jClient neo4jClient) {
        return new Neo4jTemplate(neo4jClient);
    }
}
