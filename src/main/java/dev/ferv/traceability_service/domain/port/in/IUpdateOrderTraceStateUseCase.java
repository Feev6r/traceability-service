package dev.ferv.traceability_service.domain.port.in;

import dev.ferv.traceability_service.domain.model.States;

public interface IUpdateOrderTraceStateUseCase {

    void updateState(String orderTraceId, States state);

}
