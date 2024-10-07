package com.tpo.bdd2.tpo.bdd2.model;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "hoteles")
public class Hotel {

    @Id
    private String id; // MongoDB usa un ObjectId como identificador por defecto

    @Field("nombre")
    private String nombre;

    @Field("direccion")
    private String direccion;

    @Field("telefonos")
    private List<String> telefonos;

    @Field("correo_electronico")
    private String correoElectronico;

    @Field("zona")
    private String zona;

    @Field("puntos_de_interes")
    private List<PuntoInteres> puntosDeInteres;

