package com.example.airline_api.models;

import java.util.List;

public class PassengerDTO {

    private Long passengerID;

    public PassengerDTO(Long passengerID) {
        this.passengerID = passengerID;
    }

    public PassengerDTO() {
    }

    public Long getPassengerID() {
        return passengerID;
    }

    public void setPassengerID(Long passengerID) {
        this.passengerID = passengerID;
    }
}