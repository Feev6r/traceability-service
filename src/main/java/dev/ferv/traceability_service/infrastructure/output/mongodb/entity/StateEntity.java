package dev.ferv.traceability_service.infrastructure.output.mongodb.entity;

import java.time.LocalDateTime;

import dev.ferv.traceability_service.domain.model.States;

public class StateEntity {

    States state;
    LocalDateTime time;

}
