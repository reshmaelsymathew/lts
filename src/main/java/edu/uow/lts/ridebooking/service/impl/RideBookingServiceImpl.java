package edu.uow.lts.ridebooking.service.impl;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.uow.lts.ridebooking.entity.Action;
import edu.uow.lts.ridebooking.entity.ActionType;
import edu.uow.lts.ridebooking.entity.RideBooking;
import edu.uow.lts.ridebooking.entity.Status;
import edu.uow.lts.ridebooking.repository.RideBookingRepository;
import edu.uow.lts.ridebooking.service.RideBookingService;
import edu.uow.lts.ridebooking.utility.EventLogService;

@Service
public class RideBookingServiceImpl implements RideBookingService {

    // Initialize the logger
    private static final Logger logger = LogManager.getLogger(RideBookingServiceImpl.class);

    @Autowired
    public RideBookingRepository rideBookingRepository;

    @Autowired
    private EventLogService eventLogService;

    /**
     * @param rideBooking
     * @return
     */
    @Override
    public RideBooking createRideBooking(RideBooking rideBooking) {
        logger.info("Creating a new ride booking for customer: {}", rideBooking.getConatctNumber());
        RideBooking createdBooking = rideBookingRepository.save(rideBooking);
        logger.info("Ride booking created successfully with ID: {}", createdBooking.getRideBookingId());

        // Save event log for creation action
        eventLogService.saveEventLog(1L, "admin", ActionType.CREATE, Action.RIDE_BOOKING_CREATE, Status.SUCCESS);

        return createdBooking;
    }

    @Override
    public Optional<RideBooking> getRideBookingById(Long id) {
        logger.info("Fetching ride booking by ID: {}", id);
        Optional<RideBooking> booking = rideBookingRepository.findById(id);

        // Log event for fetching by ID
        if (booking.isPresent()) {
            eventLogService.saveEventLog(1L, "admin", ActionType.GET_BY_ID, Action.RIDE_BOOKING_GET_BY_ID, Status.SUCCESS);
            logger.info("Ride booking found: {}", booking.get());
        } else {
            eventLogService.saveEventLog(1L, "admin", ActionType.GET_BY_ID, Action.RIDE_BOOKING_GET_BY_ID, Status.ERROR);
            logger.warn("Ride booking not found with ID: {}", id);
        }

        return booking;
    }

    /**
     * @return
     */
    @Override
    public List<RideBooking> getAllRideBookings() {
        logger.info("Fetching all ride bookings.");
        List<RideBooking> bookings = rideBookingRepository.findAll();
        logger.info("Total ride bookings fetched: {}", bookings.size());

        // Save event log for fetching all bookings
        eventLogService.saveEventLog(1L, "admin", ActionType.GET_ALL, Action.RIDE_BOOKING_GET_ALL, Status.SUCCESS);

        return bookings;
    }

    /**
     * @param id
     * @param rideBooking
     * @return
     */
    @Override
    public RideBooking updateRideBooking(Long id, RideBooking rideBooking) {
        logger.info("Updating ride booking with ID: {}", id);
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
            
            // Save updated booking and log the success
            RideBooking savedBooking = rideBookingRepository.save(updatedBooking);
            eventLogService.saveEventLog(1L, "admin", ActionType.UPDATE, Action.RIDE_BOOKING_UPDATE, Status.SUCCESS);
            logger.info("Ride booking updated successfully: {}", savedBooking);
            return savedBooking;
        } else {
            // Log the error if ride booking not found
            eventLogService.saveEventLog(1L, "admin", ActionType.UPDATE, Action.RIDE_BOOKING_UPDATE, Status.ERROR);
            logger.warn("Ride booking not found for update, ID: {}", id);
            throw new RuntimeException("RideBooking not found with id " + id);
        }
    }

    /**
     * @param id
     */
    @Override
    public void deleteRideBooking(Long id) {
        logger.info("Deleting ride booking with ID: {}", id);

        try {
            rideBookingRepository.deleteById(id);
            eventLogService.saveEventLog(1L, "admin", ActionType.DELETE, Action.RIDE_BOOKING_DELETE, Status.SUCCESS);
            logger.info("Ride booking with ID: {} deleted successfully.", id);
        } catch (Exception e) {
            eventLogService.saveEventLog(1L, "admin", ActionType.DELETE, Action.RIDE_BOOKING_DELETE, Status.ERROR);
            logger.error("Failed to delete ride booking with ID: {}. Error: {}", id, e.getMessage());
            throw new RuntimeException("Failed to delete RideBooking with id " + id, e);
        }
    }
}
