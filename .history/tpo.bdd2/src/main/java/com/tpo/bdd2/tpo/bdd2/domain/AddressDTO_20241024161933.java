package com.tpo.bdd2.tpo.bdd2.domain;

import java.util.UUID;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDTO {

    private UUID id; 
    private String street; 
    private String number; 
    private String city; 
    private String state; 
    private String postalCode; 
    private String country; 
    
}
