package edu.uow.lts.ridebooking.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uow.lts.ridebooking.entity.RideBooking;
import edu.uow.lts.ridebooking.repository.RideBookingRepository;
import edu.uow.lts.ridebooking.service.RideBookingService;

@Service
public class RideBookingServiceImpl implements RideBookingService {

	@Autowired
    public RideBookingRepository rideBookingRepository;
    /**
     * @param rideBooking
     * @return
     */
    @Override
    public RideBooking createRideBooking(RideBooking rideBooking) {
        return rideBookingRepository.save(rideBooking);
    }

    @Override
    public Optional<RideBooking> getRideBookingById(Long id) {
        return rideBookingRepository.findById(id);
    }

    /**
     * @return
     */
    @Override
    public List<RideBooking> getAllRideBookings() {
        return rideBookingRepository.findAll();
    }

    /**
     * @param id
     * @param rideBooking
     * @return
     */
    @Override
    public RideBooking updateRideBooking(Long id, RideBooking rideBooking) {
        Optional<RideBooking> existingBooking = rideBookingRepository.findById(id);
        if (existingBooking.isPresent()) {
            RideBooking updatedBooking = existingBooking.get();
            updatedBooking.setPickupLocation(rideBooking.getPickupLocation());
            updatedBooking.setDropOffLocation(rideBooking.getDropOffLocation());
            updatedBooking.setVehicleType(rideBooking.getVehicleType());
            updatedBooking.setRideDate(rideBooking.getRideDate());
            updatedBooking.setNoOfPassengers(rideBooking.getNoOfPassengers());
            updatedBooking.setPaymentMethod(rideBooking.getPaymentMethod());
            updatedBooking.setConatctNumber(rideBooking.getConatctNumber());
            return rideBookingRepository.save(updatedBooking);
        } else {
            throw new RuntimeException("RideBooking not found with id " + id);
        }
    }

    /**
     * @param id
     */
    @Override
    public void deleteRideBooking(Long id) {
        rideBookingRepository.deleteById(id);
    }
}
