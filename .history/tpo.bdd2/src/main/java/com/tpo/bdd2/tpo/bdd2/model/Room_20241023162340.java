package com.tpo.bdd2.tpo.bdd2.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.neo4j.core.schema.Node;

import com.tpo.bdd2.tpo.bdd2.enums.Amenities;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Node
@NoArgsConstructor
public class Room {

    @Id
    private Long roomId;

    private List<Amenities> amenities;

    private boolean isAvaible;
    private double price;

}
