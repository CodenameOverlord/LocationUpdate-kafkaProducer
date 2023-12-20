package com.deliveryBoy.locationUpdate.deliveryLocationUpdate.service;

import com.deliveryBoy.locationUpdate.deliveryLocationUpdate.ApplicationConstants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {
    @Autowired
    KafkaTemplate<String, String> kafkaTemplate;

    private Logger logger = LoggerFactory.getLogger(KafkaService.class);
    public Boolean updateLocation(String location){
        this.kafkaTemplate.send(ApplicationConstants.LOCATION_TOPIC_NAME, location);
        this.logger.info("message produced");
        return true;
    }
}
