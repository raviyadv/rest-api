package com.edu.rest.api.model;

public class FlightDetails {
    private int flightNumber;
    private String status;

    public FlightDetails(int flightNumber, String status) {
        this.flightNumber = flightNumber;
        this.status = status;
    }

    public int getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(int flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
