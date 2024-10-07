package com.tpo.bdd2.tpo.bdd2.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDTO {

    private String id; 

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
