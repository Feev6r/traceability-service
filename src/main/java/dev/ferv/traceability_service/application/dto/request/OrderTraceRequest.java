package dev.ferv.traceability_service.application.dto.request;

import dev.ferv.traceability_service.domain.model.States;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OrderTraceRequest {

    Long clientId;
    Long orderId;
    States state;
}
