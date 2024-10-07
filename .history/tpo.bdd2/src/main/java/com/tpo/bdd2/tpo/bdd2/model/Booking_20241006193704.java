package com.tpo.bdd2.tpo.bdd2.model;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Data
@NoArgsConstructor
@Document(collection = "Bookings")
public class Booking {

}
