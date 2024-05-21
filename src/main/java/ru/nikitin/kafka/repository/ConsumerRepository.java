package ru.nikitin.kafka.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.nikitin.kafka.model.entity.Metric;

import java.util.Optional;

public interface ConsumerRepository extends JpaRepository<Metric, Integer> {

    Optional<Metric> getById(Long id);

}
