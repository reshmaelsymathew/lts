package edu.uow.lts.ridebooking.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import edu.uow.lts.ridebooking.entity.RideBooking;

@Repository
public interface RideBookingRepository extends JpaRepository<RideBooking, Long> {
    // Custom query methods (if any) can be added here
}