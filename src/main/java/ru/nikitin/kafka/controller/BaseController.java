package ru.nikitin.kafka.controller;

import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.nikitin.kafka.exception.model.Exception;

public class BaseController {

    @ExceptionHandler(RuntimeException.class)
    public Exception handleException(RuntimeException e) {
        return new Exception(e.getClass().getSimpleName(), e.getMessage());
    }
}
