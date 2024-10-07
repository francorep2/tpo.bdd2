package com.tpo.bdd2.tpo.bdd2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import com.tpo.bdd2.tpo.bdd2.enums.PoiTypes;

public class Poi {

    @Id
    @Field("POI_ID")
    private String poiId;

    @Field("Name")
    private PoiTypes poiTypes;

}
