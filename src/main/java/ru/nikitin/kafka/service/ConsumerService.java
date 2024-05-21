package ru.nikitin.kafka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import ru.nikitin.kafka.model.MetricValue;

import java.util.List;

@Slf4j
@Service
public class ConsumerService {

    @KafkaListener(
            topics = "${app.kafka.topic}",
            containerFactory = "listenerContainerFactory")
    public void listen(@Payload MetricValue values) {
        log.info("value = {}", values);
//        for (MetricValue value : values) {
//            log.info("value = {}", value);
//        }
    }
}
