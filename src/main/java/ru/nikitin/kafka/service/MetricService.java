package ru.nikitin.kafka.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.nikitin.kafka.exception.AppException;
import ru.nikitin.kafka.model.MetricValue;
import ru.nikitin.kafka.model.entity.Metric;
import ru.nikitin.kafka.repository.ConsumerRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j
@Service
public class MetricService {
    private static final String MSG_NOT_FOUND_BY_KEY = "No metrics were found for this key";

    @Autowired
    ConsumerRepository repo;

    public MetricValue getMetricById(Long id) {
        log.info("getMetricById id = {}", id);
        Optional<Metric> metric = repo.getById(id);
        if (metric.isPresent()) {
            return new MetricValue(metric.get());
        } else {
            throw new AppException(MSG_NOT_FOUND_BY_KEY);
        }
    }

    public List<MetricValue> findAll() {
        return repo.findAll()
                .stream()
                .map(MetricValue::new)
                .collect(Collectors.toList());
    }
}
