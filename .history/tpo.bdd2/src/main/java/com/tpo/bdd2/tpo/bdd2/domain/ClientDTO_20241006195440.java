package com.tpo.bdd2.tpo.bdd2.domain;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ClientDTO {

    private String clientId;
    private String name;

    @Field("last_name")
    private String lastName;

    @Field("email")
    private String email;

    @Field("phone")
    private String phone;

    @Field("address")
    private Address address;
    
}
