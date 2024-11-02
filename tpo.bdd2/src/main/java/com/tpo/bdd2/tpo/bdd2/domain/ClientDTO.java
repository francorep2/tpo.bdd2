package com.tpo.bdd2.tpo.bdd2.domain;
import com.tpo.bdd2.tpo.bdd2.model.Address;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientDTO {

    private String id;
    private String name;
    private String lastName;
    private String email;
    private String phone;
    private Address address;
    
}
