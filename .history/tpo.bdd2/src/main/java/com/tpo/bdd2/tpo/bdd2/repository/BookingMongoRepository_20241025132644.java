package com.tpo.bdd2.tpo.bdd2.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.tpo.bdd2.tpo.bdd2.model.Booking;

@Repository
public interface BookingMongoRepository extends MongoRepository<Booking, Long> {


    @Query
    List<Booking> findByConfirmationNumber(String confirmationNumber);

    List<Booking> findByGuestId(String guestId);

    @Query("{ 'bookingDate': ?0 }")
    List<Booking> findByBookingDate(LocalDate bookingDate);


}
