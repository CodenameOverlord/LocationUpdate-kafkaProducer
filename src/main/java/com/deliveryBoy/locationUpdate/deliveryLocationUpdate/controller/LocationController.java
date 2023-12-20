package com.deliveryBoy.locationUpdate.deliveryLocationUpdate.controller;

import com.deliveryBoy.locationUpdate.deliveryLocationUpdate.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    KafkaService kafkaService;
    @PostMapping("/update")
    public ResponseEntity<?> updateLocation(){
        this.kafkaService.updateLocation("("+ Math.random()+", "+Math.random()+")");
        return new ResponseEntity<>(Map.of("message","Location updated successfully"), HttpStatus.OK);
    }


}
