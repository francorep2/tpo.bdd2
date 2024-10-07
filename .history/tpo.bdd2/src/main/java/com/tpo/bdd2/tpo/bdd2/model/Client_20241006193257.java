package com.tpo.bdd2.tpo.bdd2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
@Document(collection = "Client")
public class Client {

    @Id
    @Field("Client_ID")
    private String clientId;

    @Field("name")
    private String name;

    @Field("last_name")
    private String lastName;

    

}
