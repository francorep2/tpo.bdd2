package com.tpo.bdd2.tpo.bdd2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@EnableMongoRepositories(basePackages = "com.tpo.bdd2.tpo.bdd2.repository.mongo")
@EnableNeo4jRepositories(basePackages = "com.tpo.bdd2.tpo.bdd2.repository.neo4j")
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		System.err.println("START");
	}

}
