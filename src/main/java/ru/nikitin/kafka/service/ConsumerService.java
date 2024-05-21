package ru.nikitin.kafka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaHandler;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.nikitin.kafka.model.MetricValue;
import ru.nikitin.kafka.model.entity.Metric;
import ru.nikitin.kafka.repository.ConsumerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@KafkaListener(
        topics = "${app.kafka.topic}",
        containerFactory = "listenerContainerFactory")
public class ConsumerService {

    @Autowired
    private ConsumerRepository repo;

    @KafkaHandler
    public void handle(List<MetricValue> messages) {
        log.info("value = {}", messages);
        List<Metric> metrics =
                messages
                        .stream()
                        .map(Metric::new)
                        .collect(Collectors.toList());
        repo.saveAll(metrics);
    }
}
