package com.tpo.bdd2.tpo.bdd2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.Node;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Node
public class Address {

    @Id
    private Long id; 

    
    private String street; 

    private String number; 

    private String city; 

    private String state; 

    private String postalCode; 

    private String country; 
}
