package ru.nikitin.kafka.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.nikitin.kafka.model.MetricValue;

@Entity
@Table(name = "metrics")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Metric {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "type")
    String type;

    @Column(name = "key")
    String key;

    @Column(name = "value")
    String value;

    public Metric(MetricValue fromKafka) {
        this(null, fromKafka.type(), fromKafka.key(), fromKafka.value());
    }
}
