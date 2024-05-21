package ru.nikitin.kafka.model;

import ru.nikitin.kafka.model.entity.Metric;

public record MetricValue(String type, String key, String value) {
    public MetricValue(Metric metric) {
        this(metric.getType(), metric.getKey(), metric.getValue());
    }
}
