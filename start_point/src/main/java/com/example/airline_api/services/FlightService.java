package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository; //do i really want this here?

    public List<Flight> displayAll(){
        return flightRepository.findAll();
    }

    public Flight displayById(Long id){
        return flightRepository.findById(id).get();
    }

    public void saveFlight(Flight flight){
        flightRepository.save(flight);
    }

    public void cancelFlight(Long id){
//        Flight flight = flightRepository.findById(id).get();
//        may need to remove bookings with this flight later on!! in a for loop
        flightRepository.deleteById(id);

    }
    public void bookPassenger(Long idFlight, Passenger passenger){
        Flight flight = flightRepository.findById(idFlight).get();
        flight.getPassengers().add(passenger);
    }

}
