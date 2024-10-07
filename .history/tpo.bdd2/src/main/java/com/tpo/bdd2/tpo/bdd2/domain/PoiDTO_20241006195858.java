package com.tpo.bdd2.tpo.bdd2.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import com.tpo.bdd2.tpo.bdd2.enums.PoiTypes;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PoiDTO {

        @Id
    @Field("POI_ID")
    private String poiId;

    @Field("Name")
    private PoiTypes poiTypes;
    
}
