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

    public RideBooking(Long rideBookingId, String pickupLocation, String dropOffLocation, @NonNull VehicleType vehicleType, Date rideDate, Integer noOfPassengers, @NonNull PaymentMethod paymentMethod, @NonNull String conatctNumber) {
        this.rideBookingId = rideBookingId;
        this.pickupLocation = pickupLocation;
        this.dropOffLocation = dropOffLocation;
        this.vehicleType = vehicleType;
        this.rideDate = rideDate;
        this.noOfPassengers = noOfPassengers;
        this.paymentMethod = paymentMethod;
        this.conatctNumber = conatctNumber;
    }

    public RideBooking() {

    }

    public Long getRideBookingId() {
        return rideBookingId;
    }

    public void setRideBookingId(Long rideBookingId) {
        this.rideBookingId = rideBookingId;
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

    @NonNull
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(@NonNull VehicleType vehicleType) {
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

    @NonNull
    public PaymentMethod getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(@NonNull PaymentMethod paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    @NonNull
    public String getConatctNumber() {
        return conatctNumber;
    }

    public void setConatctNumber(@NonNull String conatctNumber) {
        this.conatctNumber = conatctNumber;
    }

    @Override
    public String toString() {
        return "RideBooking{" +
                "rideBookingId=" + rideBookingId +
                ", pickupLocation='" + pickupLocation + '\'' +
                ", dropOffLocation='" + dropOffLocation + '\'' +
                ", vehicleType=" + vehicleType +
                ", rideDate=" + rideDate +
                ", noOfPassengers=" + noOfPassengers +
                ", paymentMethod=" + paymentMethod +
                ", conatctNumber='" + conatctNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RideBooking that = (RideBooking) o;
        return Objects.equals(rideBookingId, that.rideBookingId) && Objects.equals(pickupLocation, that.pickupLocation) && Objects.equals(dropOffLocation, that.dropOffLocation) && vehicleType == that.vehicleType && Objects.equals(rideDate, that.rideDate) && Objects.equals(noOfPassengers, that.noOfPassengers) && paymentMethod == that.paymentMethod && Objects.equals(conatctNumber, that.conatctNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(rideBookingId, pickupLocation, dropOffLocation, vehicleType, rideDate, noOfPassengers, paymentMethod, conatctNumber);
    }
}
