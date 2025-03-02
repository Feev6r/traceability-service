package dev.ferv.traceability_service.application.useCase;

import org.springframework.stereotype.Component;

import dev.ferv.traceability_service.domain.model.OrderTrace;
import dev.ferv.traceability_service.domain.port.in.IGetOrderTraceUseCase;
import dev.ferv.traceability_service.domain.port.out.IOrderTracePort;

@Component
public class GetOrderTraceUseCase implements IGetOrderTraceUseCase{

    private final IOrderTracePort orderTracePort;

    public GetOrderTraceUseCase(IOrderTracePort orderTracePort) {
        this.orderTracePort = orderTracePort;
    }

    @Override
    public OrderTrace getOrderTrace(Long orderId) {
        return orderTracePort.getOrderTraceByOrderId(orderId);
    }

}
