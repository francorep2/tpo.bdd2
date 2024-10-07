package com.tpo.bdd2.tpo.bdd2.domain;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;

import com.tpo.bdd2.tpo.bdd2.enums.Amenities;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoomDTO {

    private String roomId;
    private List<Amenities> amenities;

    @Field("isAvaible")
    private boolean isAvaible;

    @Field("Price")
    private double price;

    
}
