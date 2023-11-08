package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FlightService {
    @Autowired
    FlightRepository flightRepository;
    @Autowired
    PassengerService passengerService;

    public List<Flight> displayAll(){
        return flightRepository.findAll();
    }

    public Flight displayById(Long id){
        return flightRepository.findById(id).get();
    }

    public void saveFlight(Flight flight){
        flightRepository.save(flight);
    }

    public void cancelFlight(Long flightId){
//        may need to remove bookings with this flight later on!! in a for loop
//        remove flight from passengers flight list!!
        Flight flight = flightRepository.findById(flightId).get();
        for (Passenger passenger : flight.getPassengers()){
            passenger.cancelFlight(flight);
        }
        flightRepository.deleteById(flightId);

    }

    @Transactional
    public void bookPassenger(Long flightId, Long passengerId){
        Flight flight = flightRepository.findById(flightId).get();
        Passenger passenger = passengerService.displayById(passengerId);
        passenger.bookFlight(flight);
        flight.addPassenger(passenger);
    }

}
