package com.example.airline_api.controllers;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.models.PassengerDTO;
import com.example.airline_api.services.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {

    @Autowired
    FlightService flightService;

    // Display all available flights - DONE
    @GetMapping
    public ResponseEntity<List<Flight>> getAllFlights(
            @RequestParam(required=false, name = "destination")String destination){
        if(destination != null){
            return new ResponseEntity<>(flightService.findByDestination(destination), HttpStatus.OK);
        }
        return new ResponseEntity<>(flightService.displayAll(), HttpStatus.OK);
    }

    // Display a specific flight - DONE
    @GetMapping(value = "/{id}")
    public ResponseEntity<Flight> getFlightById(@PathVariable Long id){
        return new ResponseEntity<>(flightService.displayById(id), HttpStatus.OK);
    }

    // Add details of a new flight - DONE
    @PostMapping
    public ResponseEntity<Flight> addNewFlight(@RequestBody Flight flight){
        flightService.saveFlight(flight);
        return new ResponseEntity<>(flight, HttpStatus.CREATED);
    }

    // Book passenger on a flight - DONE may need refactoring with bookings class
    @PatchMapping(value = "/{id}")
    public ResponseEntity<Flight> addPassengerToFlight(@PathVariable Long id,
                                                       @RequestBody PassengerDTO passengerDTO){
//        Passenger passenger = new Passenger(passengerDTO.getName(), passengerDTO.getEmail());
//        passenger.setFlights(passengerDTO.getFlights());
        flightService.bookPassenger(id, passengerDTO.getPassengerID());
        return new ResponseEntity<>(flightService.displayById(id), HttpStatus.OK);
    }

    // Cancel flight - DONE may need refactoring with bookings class
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<List<Flight>> cancelFlight(@PathVariable Long id){
        flightService.cancelFlight(id);
        return new ResponseEntity<>(flightService.displayAll(), HttpStatus.OK);
    }

}
