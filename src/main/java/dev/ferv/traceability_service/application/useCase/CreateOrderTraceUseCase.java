package dev.ferv.traceability_service.application.useCase;

import org.springframework.stereotype.Component;

import dev.ferv.traceability_service.domain.model.OrderTrace;
import dev.ferv.traceability_service.domain.port.in.ICreateOrderTraceUseCase;
import dev.ferv.traceability_service.domain.port.out.IOrderTracePort;

@Component
public class CreateOrderTraceUseCase implements ICreateOrderTraceUseCase{

    private final IOrderTracePort orderTracePort;

    public CreateOrderTraceUseCase(IOrderTracePort orderTracePort) {
        this.orderTracePort = orderTracePort;
    }

    @Override
    public void createOrderTrace(OrderTrace orderTrace) {
        orderTracePort.createOrderTrace(orderTrace);
    }

}
