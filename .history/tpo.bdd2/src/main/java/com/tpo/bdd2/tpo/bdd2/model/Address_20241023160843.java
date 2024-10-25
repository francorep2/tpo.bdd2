package com.tpo.bdd2.tpo.bdd2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.neo4j.core.schema.Node;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Node
public class Address {

    @Id
    @Field("address_id")
    private Long id; 

    @Field("street")
    private String street; 

    @Field("number")
    private String number; 

    @Field("city")
    private String city; 

    @Field("state")
    private String state; 

    @Field("postal_code")
    private String postalCode; 

    @Field("country")
    private String country; 
}
