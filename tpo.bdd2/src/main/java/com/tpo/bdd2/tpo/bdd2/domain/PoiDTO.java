package com.tpo.bdd2.tpo.bdd2.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PoiDTO {

    private String poiId;
    private String poiName;
    private String poiDescription;
    private String poiDistance;
    
}
