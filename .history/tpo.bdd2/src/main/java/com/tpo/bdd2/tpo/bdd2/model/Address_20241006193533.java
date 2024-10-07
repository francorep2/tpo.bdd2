package com.tpo.bdd2.tpo.bdd2.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@NoArgsConstructor
@Document(collection = "addresses")
public class Address {

    @Id
    private String id; 

    @Field("street")
    private String street; 

    @Field("number")
    private String number; // Número de la calle

    @Field("city")
    private String city; 

    @Field("state")
    private String state; 

    @Field("postal_code")
    private String postalCode; 

    @Field("country")
    private String country; 
}
