package com.Custom.Queries1.demoCustomQueries1;

import com.Custom.Queries1.demoCustomQueries1.FlightRepository;
import com.Custom.Queries1.demoCustomQueries1.Flights;
import com.Custom.Queries1.demoCustomQueries1.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@RestController
@RequestMapping("/flights")
public class FlightsController{

    @Autowired
    private FlightRepository flightRepository;

    @GetMapping("/provision")
    public List<Flights> provisionFlights() {
        Random random = new Random();
        List<Flights> flights = IntStream.range(0, 50)
                .mapToObj(i -> {
                    Flights flight = new Flights();
                    flight.setDescription("Flight " + i);
                    flight.setFromAirport(randomString(random));
                    flight.setToAirport(randomString(random));
                    flight.setStatus(Status.ON_TIME);
                    return flight;
                })
                .collect(Collectors.toList());

        return flightRepository.saveAll(flights);
    }

    @GetMapping
    public List<Flights> getAllFlights() {
        return flightRepository.findAll();
    }

    private String randomString(Random random) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 5;
        return random.ints(leftLimit, rightLimit + 1)
                .limit(targetStringLength)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}