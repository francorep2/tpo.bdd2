package com.tpo.bdd2.tpo.bdd2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.tpo.bdd2.tpo.bdd2.repository")
@EnableNeo4jRepositories(basePackages = "com.tpo.bdd2.tpo.bdd2.repository")

public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.out.println("SPRING BOOT APP START");
	}

}
