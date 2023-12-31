package com.example.airline_api.services;

import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {
    @Autowired
    PassengerRepository passengerRepository;

    public List<Passenger> displayAll(){
        return passengerRepository.findAll();
    }
    public Passenger displayById(Long id){
        return passengerRepository.findById(id).get();
    }
    public void savePassenger(Passenger passenger){
        passengerRepository.save(passenger);
    }


}
