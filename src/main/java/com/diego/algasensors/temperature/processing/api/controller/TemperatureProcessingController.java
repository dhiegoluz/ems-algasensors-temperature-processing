package com.diego.algasensors.temperature.processing.api.controller;


import com.diego.algasensors.temperature.processing.api.model.TemperatureLogOutput;
import com.diego.algasensors.temperature.processing.common.IdGenerator;
import io.hypersistence.tsid.TSID;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/api/sensors/{sensorId}/temperatures/data")
public class TemperatureProcessingController {


    @PostMapping(consumes = MediaType.TEXT_PLAIN_VALUE)
    public void data(@PathVariable TSID sensorId, @RequestBody String input) {

        if(input == null || input.isBlank())
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);


        Double temperature;

        try {
            temperature = Double.parseDouble(input);
        } catch (NumberFormatException e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
        }

        TemperatureLogOutput temperatureLogOutput = TemperatureLogOutput.builder()
                .id(IdGenerator.generateTimeBasedUUID())
                .sensorId(sensorId)
                .value(temperature)
                .registeredAt(OffsetDateTime.now())
                .build();

        System.out.println(temperatureLogOutput);
    }
}
