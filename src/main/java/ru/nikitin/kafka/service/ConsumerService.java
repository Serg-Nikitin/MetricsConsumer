package ru.nikitin.kafka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import ru.nikitin.kafka.model.MetricValue;
import ru.nikitin.kafka.model.entity.Metric;
import ru.nikitin.kafka.repository.ConsumerRepository;

@Slf4j
@Service
public class ConsumerService {

    @Autowired
    private ConsumerRepository repo;

    @KafkaListener(
            topics = "${app.kafka.topic}",
            containerFactory = "listenerContainerFactory")
    public void listen(@Payload MetricValue message) {
        log.info("value = {}", message);
        repo.save(new Metric(message));
//        for (MetricValue value : values) {
//            log.info("value = {}", value);
//        }
    }
}
