package dev.ferv.traceability_service.infrastructure.output.mongodb.entity;

import java.time.LocalDateTime;
import dev.ferv.traceability_service.domain.model.States;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class StateTraceEntity {

    States state;
    LocalDateTime completionDate;
}
