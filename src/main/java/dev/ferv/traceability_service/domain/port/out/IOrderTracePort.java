package dev.ferv.traceability_service.domain.port.out;

import dev.ferv.traceability_service.domain.model.OrderTrace;

public interface IOrderTracePort {

    void createOrderTrace(OrderTrace orderTrace);
    void updateOrderTrace(OrderTrace orderTrace);
}
