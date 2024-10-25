package com.tpo.bdd2.tpo.bdd2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
@Node
public class Client {

    @Id
    private Long clientId;

    private String name;

    private String lastName;

    private String email;

    private String phone;

    @Relationship(type = "LIVES_IN")
    private Address address;

}
