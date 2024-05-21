package ru.nikitin.kafka.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nikitin.kafka.model.MetricValue;
import ru.nikitin.kafka.service.MetricService;

import java.util.Collection;

@Slf4j
@RestController
@RequestMapping(path = "/consumer/metrics")
public class ConsumerController extends BaseController {

    @Autowired
    MetricService metricService;

    @GetMapping("/{id}")
    public MetricValue getMetricsByKey(@PathVariable Long id) {
        log.info("getMetricsByKey id = {}", id);
        return metricService.getMetricById(id);
    }

    @GetMapping("/")
    public Collection<MetricValue> getAllMetrics() {
        log.info("getAllMetrics ");
        return metricService.findAll();
    }
}
