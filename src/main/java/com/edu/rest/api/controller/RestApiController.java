package com.edu.rest.api.controller;

import com.edu.rest.api.model.FlightDetails;
import com.edu.rest.api.model.GenericResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@RestController
@RequestMapping("/cargo")
public class RestApiController {

    private Map<Integer,FlightDetails> flight = new HashMap<>();
    @GetMapping("/airline/{airlineNo}/status")
    public ResponseEntity<GenericResponse> getStatus(@PathVariable("airlineNo") String flightNumber) {
        if (Objects.isNull(flightNumber) || !StringUtils.isNumeric(flightNumber))
            return ResponseEntity.badRequest().body(new GenericResponse(400, "flight number should be numeric and non empty", null));
        return ResponseEntity.ok(new GenericResponse(200, "success", flight.get(Integer.parseInt(flightNumber))));
    }

    @PostMapping("/airline/addFlight")
    public ResponseEntity<GenericResponse> addFlight(@RequestBody FlightDetails flightDetails) {
        flight.put(flightDetails.getFlightNumber(),flightDetails);
        return ResponseEntity.ok(new GenericResponse(200,"success",null));
    }

    @PutMapping("/airline/flight/updateFlight")
    public ResponseEntity<GenericResponse> updateFlight(@RequestBody FlightDetails flightDetails) {
        if (Objects.isNull(flight.get(flightDetails.getFlightNumber()))) {
            return ResponseEntity.badRequest().body(new GenericResponse(400, "invalid flight", null));
        }
        flight.put(flightDetails.getFlightNumber(), flightDetails);
        return ResponseEntity.ok(new GenericResponse(200, "success", null));
    }

    @DeleteMapping("/airline/delete/flight/{flightNumber}")
    public ResponseEntity<GenericResponse> deleteFlight(@PathVariable("flightNumber") String flightNumber) {
        flight.remove(Integer.parseInt(flightNumber));
        return ResponseEntity.ok(new GenericResponse(200, "success", null));
    }

    @GetMapping("/airline/status")
    public ResponseEntity<GenericResponse>  getAllStatus() {
        return ResponseEntity.ok(new GenericResponse(200, "success", flight));
    }
}