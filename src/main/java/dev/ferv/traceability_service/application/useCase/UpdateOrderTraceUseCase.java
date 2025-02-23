package dev.ferv.traceability_service.application.useCase;

import org.springframework.stereotype.Component;

import dev.ferv.traceability_service.domain.model.States;
import dev.ferv.traceability_service.domain.port.in.IUpdateOrderTraceStateUseCase;
import dev.ferv.traceability_service.domain.port.out.IOrderTracePort;

@Component
public class UpdateOrderTraceUseCase implements IUpdateOrderTraceStateUseCase{

    private final IOrderTracePort orderTracePort; 

    public UpdateOrderTraceUseCase(IOrderTracePort orderTracePort) {
        this.orderTracePort = orderTracePort;
    }

    @Override
    public void updateState(Long orderId, States state) {
        // orderTracePort
    }

}
