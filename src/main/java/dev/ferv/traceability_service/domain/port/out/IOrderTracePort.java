package dev.ferv.traceability_service.domain.port.out;

import dev.ferv.traceability_service.domain.model.OrderTrace;
import dev.ferv.traceability_service.domain.model.StateTrace;

public interface IOrderTracePort {

    void createOrderTrace(OrderTrace orderTrace);
    void updateOrderTrace(String orderTraceId, StateTrace orderTrace);
}
