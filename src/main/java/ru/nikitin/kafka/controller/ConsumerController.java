package ru.nikitin.kafka.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.nikitin.kafka.exception.AppException;
import ru.nikitin.kafka.model.entity.Metric;
import ru.nikitin.kafka.service.MetricService;

import java.util.Optional;

@Slf4j
@RestController
@RequestMapping(path = "/consumer/metrics")
public class ConsumerController extends BaseController {

    private static final String MSG_NOT_FOUND_BY_KEY = "No metrics were found for this key";

    @Autowired
    MetricService metricService;

    @GetMapping("/performance/{key}")
    public Metric getPerformanceByKey(@PathVariable String key) {
        log.info("getPerformanceByKey key = {}", key);
        Optional<Metric> metric = metricService.getMetricByKey(key);
         if(metric.isPresent()) {
             return metric.get();
         } else {
             throw new AppException(MSG_NOT_FOUND_BY_KEY);
         }
    }
}
