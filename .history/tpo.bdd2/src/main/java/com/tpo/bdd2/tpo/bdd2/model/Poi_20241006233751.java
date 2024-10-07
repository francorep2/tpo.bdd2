package com.tpo.bdd2.tpo.bdd2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.neo4j.core.schema.Node;

import com.tpo.bdd2.tpo.bdd2.enums.PoiTypes;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@Node
@NoArgsConstructor
@Document(collection = "Points_of_Interest")
public class Poi {

    @Id
    @Field("POI_ID")
    private Long poiId;

    @Field("Name")
    private PoiTypes poiTypes;

}
