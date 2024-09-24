package edu.uow.lts.ridebooking.entity;

public enum Action {
    RIDE_BOOKING_CREATE("RIDE_BOOKING_CREATE"),
    RIDE_BOOKING_UPDATE("RIDE_BOOKING_UPDATE"),
    RIDE_BOOKING_DELETE("RIDE_BOOKING_DELETE"),
    RIDE_BOOKING_GET_BY_ID("RIDE_BOOKING_GET_BY_ID"),
    RIDE_BOOKING_GET_ALL("RIDE_BOOKING_GET_ALL");

    private final String actionName;

    private Action(String actionName) {
        this.actionName = actionName;
    }

    public String getActionName() {
        return actionName;
    }

    @Override
    public String toString() {
        return actionName;
    }
}
