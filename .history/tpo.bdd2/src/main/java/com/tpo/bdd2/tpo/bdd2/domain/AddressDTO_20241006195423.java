package com.tpo.bdd2.tpo.bdd2.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddressDTO {

    private String id; 
    private String street; 
    private String number; 
    private String city; 
    private String state; 
    private String postalCode; 
    private String country; 
    
}
