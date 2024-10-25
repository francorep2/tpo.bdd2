package com.tpo.bdd2.tpo.bdd2.repository;

import java.util.UUID;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.tpo.bdd2.tpo.bdd2.model.Booking;

import java.

@Repository
public interface BookingMongoRepository extends MongoRepository<Booking, Long> {


    List<Booking> findByConfirmationNumber(String confirmationNumber);

    List<Booking> findByGuestId(String guestId);

    @Query("{ 'bookingDate': ?0 }")
    List<Booking> findByBookingDate(LocalDate bookingDate);


}
