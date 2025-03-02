package dev.ferv.traceability_service.application.dto.response;

import dev.ferv.traceability_service.domain.model.States;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class StateTraceResponse {

    private States state;
    private String completedDate;
}
