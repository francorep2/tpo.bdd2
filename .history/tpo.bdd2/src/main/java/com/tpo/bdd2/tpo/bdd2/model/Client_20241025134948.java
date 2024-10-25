package com.tpo.bdd2.tpo.bdd2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
@Node
public class Client {

    @Schema(description = "ID ", example = "1")
    @Id
    @GeneratedValue
    private Long clientId;

    @Schema(description = "Client name", example = "John")
    private String name;

    @Schema(description = "Client last name", example = "Doe")
    private String lastName;

    @Schema(description = "Client email", example = "john.doe@example.com")
    private String email;

    @Schema(description = "Client phone", example = "1234567890")
    private String phone;

    @Schema(description = "Client address")
    @Relationship(type = "LIVES_IN")
    private Address address;

}
