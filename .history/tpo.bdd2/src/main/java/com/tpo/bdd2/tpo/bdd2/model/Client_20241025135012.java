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

    @Schema(description = "Cliente ID ", example = "1")
    @Id
    @GeneratedValue
    private Long clientId;

    @Schema(description = "Nombre Cliente", example = "John")
    private String name;

    @Schema(description = "Apellido Cliente", example = "Doe")
    private String lastName;

    @Schema(description = "Email Cliente", example = "john.doe@example.com")
    private String email;

    @Schema(description = "Telefono Cliente", example = "1234567890")
    private String phone;

    @Schema(description = "Client address")
    @Relationship(type = "LIVES_IN")
    private Address address;

}
