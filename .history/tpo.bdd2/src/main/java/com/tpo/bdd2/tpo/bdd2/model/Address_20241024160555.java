package com.tpo.bdd2.tpo.bdd2.model;

import java.util.UUID;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Node
public class Address {

      @Id
    private String id = UUID.randomUUID().toString();

    private String street; 

    private String number; 

    private String city; 

    private String state; 

    private String postalCode; 

    private String country; 
}
