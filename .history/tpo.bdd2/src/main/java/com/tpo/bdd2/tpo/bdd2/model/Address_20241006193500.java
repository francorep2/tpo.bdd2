package com.tpo.bdd2.model;

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
    private String id; // Puedes usar un ID único para la dirección, si lo deseas

    @Field("street")
    private String street; // Calle

    @Field("number")
    private String number; // Número de la calle

    @Field("city")
    private String city; // Ciudad

    @Field("state")
    private String state; // Provincia o Estado

    @Field("postal_code")
    private String postalCode; // Código postal

    @Field("country")
    private String country; // País
}
