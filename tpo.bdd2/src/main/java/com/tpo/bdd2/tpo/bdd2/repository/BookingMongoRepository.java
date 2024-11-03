package com.tpo.bdd2.tpo.bdd2.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.tpo.bdd2.tpo.bdd2.model.Booking;

@Repository
public interface BookingMongoRepository extends MongoRepository<Booking, String> {


    List<Booking> findByConfirmationNumber(String confirmationNumber);

    List<Booking> findByClientId(String clientId);
    
    List<Booking> findByBookingDate(LocalDate bookingDate);


}
