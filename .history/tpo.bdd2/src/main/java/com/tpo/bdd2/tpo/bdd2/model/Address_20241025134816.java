package com.tpo.bdd2.tpo.bdd2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Node;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Node
public class Address {

    @Schema(description = "Dirreccion ID", example = "1")
    @Id
    @GeneratedValue
    private Long id; 

    @Schema(description = "Calle", example = "Calle falsa 123")
    private String street; 

    
    private String number; 

    private String city; 

    private String state; 

    private String postalCode; 

    private String country; 
}
