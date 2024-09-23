package edu.uow.lts.ridebooking.service;

import java.util.List;
import java.util.Optional;

import edu.uow.lts.ridebooking.entity.RideBooking;

public interface RideBookingService {
	
    RideBooking createRideBooking(RideBooking rideBooking);
    Optional<RideBooking> getRideBookingById(Long id);
    List<RideBooking> getAllRideBookings();
    RideBooking updateRideBooking(Long id, RideBooking rideBooking);
    void deleteRideBooking(Long id);

}
