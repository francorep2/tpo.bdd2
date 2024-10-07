package com.tpo.bdd2.tpo.bdd2.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import com.tpo.bdd2.tpo.bdd2.enums.PoiTypes;

@Slf4j
@Data
@Node
@NoArgsConstructor
@Document(collection = "Rooms")
public class Poi {

    @Id
    @Field("POI_ID")
    private Long poiId;

    @Field("Name")
    private PoiTypes poiTypes;

}
