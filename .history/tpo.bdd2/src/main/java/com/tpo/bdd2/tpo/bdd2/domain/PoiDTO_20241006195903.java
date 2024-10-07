package com.tpo.bdd2.tpo.bdd2.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import com.tpo.bdd2.tpo.bdd2.enums.PoiTypes;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PoiDTO {

    private String poiId;
    private PoiTypes poiTypes;
    
}
