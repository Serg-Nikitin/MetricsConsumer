package ru.nikitin.kafka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nikitin.kafka.model.entity.Metric;
import ru.nikitin.kafka.repository.ConsumerRepository;

import java.util.Optional;

@Slf4j
@Service
public class MetricService {

    @Autowired
    ConsumerRepository repo;

    public Optional<Metric> getMetricByKey(String key) {
        log.info("getMetricByKey key = {}", key);
        return repo.getByKey(key);
    }

}
