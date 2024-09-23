package edu.uow.lts.ridebooking.controller;

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
    
	@Autowired
    public RideBookingService rideBookingService;	

    // Create a new ride booking
    @PostMapping
    public ResponseEntity<RideBooking> createRideBooking(@RequestBody RideBooking rideBooking) {
        RideBooking newBooking = rideBookingService.createRideBooking(rideBooking);
        return ResponseEntity.ok(newBooking);
    }

    // Get a ride booking by ID
    @GetMapping("/{id}")
    public ResponseEntity<RideBooking> getRideBookingById(@PathVariable Long id) {
        Optional<RideBooking> rideBooking = rideBookingService.getRideBookingById(id);
        return rideBooking.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Get all ride bookings
    @GetMapping
    public List<RideBooking> getAllRideBookings() {
        return rideBookingService.getAllRideBookings();
    }

    // Update a ride booking by ID
    @PutMapping("/{id}")
    public ResponseEntity<RideBooking> updateRideBooking(@PathVariable Long id, @RequestBody RideBooking rideBooking) {
        RideBooking updatedBooking = rideBookingService.updateRideBooking(id, rideBooking);
        return ResponseEntity.ok(updatedBooking);
    }

    // Delete a ride booking by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRideBooking(@PathVariable Long id) {
        rideBookingService.deleteRideBooking(id);
        return ResponseEntity.noContent().build();
    }
}