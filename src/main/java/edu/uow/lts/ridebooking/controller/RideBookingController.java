package edu.uow.lts.ridebooking.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import edu.uow.lts.ridebooking.entity.RideBooking;
import edu.uow.lts.ridebooking.service.RideBookingService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/ridebookings")
public class RideBookingController {

    // Initialize the Log4j2 logger
    private static final Logger logger = LogManager.getLogger(RideBookingController.class);

    @Autowired
    public RideBookingService rideBookingService;

    // Create a new ride booking
    @PostMapping
    public ResponseEntity<RideBooking> createRideBooking(@RequestBody RideBooking rideBooking) {
        logger.info("Creating a new ride booking for: {}", rideBooking.getConatctNumber());
        RideBooking newBooking = rideBookingService.createRideBooking(rideBooking);
        logger.info("Ride booking created successfully: {}", newBooking);
        return ResponseEntity.ok(newBooking);
    }

    // Get a ride booking by ID
    @GetMapping("/{id}")
    public ResponseEntity<RideBooking> getRideBookingById(@PathVariable Long id) {
        logger.info("Fetching ride booking by ID: {}", id);
        Optional<RideBooking> rideBooking = rideBookingService.getRideBookingById(id);
        
        if (rideBooking.isPresent()) {
            logger.info("Ride booking found: {}", rideBooking.get());
            return ResponseEntity.ok(rideBooking.get());
        } else {
            logger.warn("Ride booking not found with ID: {}", id);
            return ResponseEntity.notFound().build();
        }
    }

    // Get all ride bookings
    @GetMapping
    public List<RideBooking> getAllRideBookings() {
        logger.info("Fetching all ride bookings");
        List<RideBooking> bookings = rideBookingService.getAllRideBookings();
        logger.info("Number of ride bookings fetched: {}", bookings.size());
        return bookings;
    }

    // Update a ride booking by ID
    @PutMapping("/{id}")
    public ResponseEntity<RideBooking> updateRideBooking(@PathVariable Long id, @RequestBody RideBooking rideBooking) {
        logger.info("Updating ride booking with ID: {}", id);
        RideBooking updatedBooking = rideBookingService.updateRideBooking(id, rideBooking);
        if (updatedBooking != null) {
            logger.info("Ride booking updated successfully: {}", updatedBooking);
            return ResponseEntity.ok(updatedBooking);
        } else {
            logger.warn("Ride booking not found for update, ID: {}", id);
            return ResponseEntity.notFound().build();
        }
    }

    // Delete a ride booking by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRideBooking(@PathVariable Long id) {
        logger.info("Deleting ride booking with ID: {}", id);
        rideBookingService.deleteRideBooking(id);
        logger.info("Ride booking with ID: {} deleted successfully", id);
        return ResponseEntity.noContent().build();
    }
}
