package dev.ferv.traceability_service.application.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeTraceSignRequest {

    Long employeeId;
    Long orderId;
}
