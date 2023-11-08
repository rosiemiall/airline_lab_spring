package com.example.airline_api.components;

import com.example.airline_api.AirlineApiApplication;
import com.example.airline_api.models.Flight;
import com.example.airline_api.models.Passenger;
import com.example.airline_api.repositories.FlightRepository;
import com.example.airline_api.repositories.PassengerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner{

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    public DataLoader() {
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {


        Flight flight1 = new Flight("Paris",1,"7/11/23","12:00");
        flightRepository.save(flight1);
        Flight flight2 = new Flight("New York",150,"7/11/23","14:00");
        flightRepository.save(flight2);

        Passenger passenger1 = new Passenger("Rosie", "rosie@email.com");
        passengerRepository.save(passenger1);
        Passenger passenger2 = new Passenger("Anna", "anna@email.com");
        passengerRepository.save(passenger2);

    }
}


//implements ApplicationRunner