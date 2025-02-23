package dev.ferv.traceability_service.domain.port.in;

import dev.ferv.traceability_service.domain.model.OrderTrace;

public interface ICreateOrderTraceUseCase {

    void createOrderTrace(OrderTrace orderTrace);
}
