package edu.uow.lts.ridebooking.entity;

public enum VehicleType {
    CAR("Car"),
    BUS("Bus"),
    TRAIN("Train");

    private final String displayName;

    VehicleType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return "VehicleType{" +
                "displayName='" + displayName + '\'' +
                '}';
    }
}