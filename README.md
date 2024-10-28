# Spring Boot Project - TPO BDD2

## Descripción

Este proyecto es una aplicación de gestión de reservas y habitaciones utilizando **Spring Boot**, **MongoDB**, y **Neo4j**. El objetivo es facilitar la administración de reservas de hoteles, incluyendo la búsqueda de habitaciones disponibles y la gestión de puntos de interés.

## Documentación de la API

La documentación de la API está disponible a través de Swagger. Puedes acceder a ella en la siguiente URL:

[Documentación de la API](http://localhost:8080/swagger-ui/index.html)

## Versiones

- **Java**: 17

## Requisitos

Asegúrate de tener instalados los siguientes componentes en tu entorno de desarrollo:

- **Java 17** o superior
- **Maven** para la gestión de dependencias
- **MongoDB** y **Neo4j** para la base de datos
- **Agregar en launch.json** : "vmArgs": "--add-opens java.base/java.lang=ALL-UNNAMED"


## Datos para las Bases de Datos

En el directorio `tpo.bdd2/src/main/resources`, se encuentra el archivo `application.properties`.

### Verificar

Asegúrate de que la siguiente línea tenga tu cadena de conexión a MongoDB:

```properties
spring.data.mongodb.uri= <tu_string_de_conexion>
```

## Configuración del Proyecto

1. **Clonar el repositorio:**

   ```bash
   git clone <URL_DEL_REPOSITORIO>
   cd TPO-BDD2
   ```
