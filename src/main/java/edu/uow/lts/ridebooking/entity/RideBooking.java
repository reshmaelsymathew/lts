package edu.uow.lts.ridebooking.entity;

import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.util.Date;
import java.util.Objects;

@Entity
public class RideBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long rideBookingId;
    
    private String visitorName;

    private String pickupLocation;

    private String dropOffLocation;

    @NonNull
    @Enumerated(EnumType.STRING)
    private VehicleType vehicleType;

    private Date rideDate;

    private Integer noOfPassengers;

    @NonNull
    @Enumerated(EnumType.STRING)
    private PaymentMethod paymentMethod;

    @NonNull
    private String conatctNumber;

	public RideBooking(Long rideBookingId, String visitorName, String pickupLocation, String dropOffLocation,
			VehicleType vehicleType, Date rideDate, Integer noOfPassengers, PaymentMethod paymentMethod,
			String conatctNumber) {
		super();
		this.rideBookingId = rideBookingId;
		this.visitorName = visitorName;
		this.pickupLocation = pickupLocation;
		this.dropOffLocation = dropOffLocation;
		this.vehicleType = vehicleType;
		this.rideDate = rideDate;
		this.noOfPassengers = noOfPassengers;
		this.paymentMethod = paymentMethod;
		this.conatctNumber = conatctNumber;
	}

	public RideBooking() {}
	
	public Long getRideBookingId() {
		return rideBookingId;
	}

	public void setRideBookingId(Long rideBookingId) {
		this.rideBookingId = rideBookingId;
	}

	public String getVisitorName() {
		return visitorName;
	}

	public void setVisitorName(String visitorName) {
		this.visitorName = visitorName;
	}

	public String getPickupLocation() {
		return pickupLocation;
	}

	public void setPickupLocation(String pickupLocation) {
		this.pickupLocation = pickupLocation;
	}

	public String getDropOffLocation() {
		return dropOffLocation;
	}

	public void setDropOffLocation(String dropOffLocation) {
		this.dropOffLocation = dropOffLocation;
	}

	public VehicleType getVehicleType() {
		return vehicleType;
	}

	public void setVehicleType(VehicleType vehicleType) {
		this.vehicleType = vehicleType;
	}

	public Date getRideDate() {
		return rideDate;
	}

	public void setRideDate(Date rideDate) {
		this.rideDate = rideDate;
	}

	public Integer getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(Integer noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public String getConatctNumber() {
		return conatctNumber;
	}

	public void setConatctNumber(String conatctNumber) {
		this.conatctNumber = conatctNumber;
	}

    
    
    
}
