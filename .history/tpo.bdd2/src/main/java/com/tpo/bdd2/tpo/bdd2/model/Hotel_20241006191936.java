package com.tpo.bdd2.tpo.bdd2.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Document(collection = "Hotels")
public class Hotel {

    @Id
    private String id; 

    @Field("name")
    private String name;

    @Field("address")
    private String address;

    @Field("phone_number")
    private List<String> telefonos;

    @Field("correo_electronico")
    private String correoElectronico;

    @Field("zona")
    private String zona;

   // @Field("puntos_de_interes")
   // private List<PuntoInteres> puntosDeInteres;

}