package dev.ferv.traceability_service.application.useCase;

import org.springframework.stereotype.Component;
import dev.ferv.traceability_service.domain.model.States;
import dev.ferv.traceability_service.domain.port.in.IUpdateOrderTraceStateUseCase;
import dev.ferv.traceability_service.domain.service.interfaces.IOrderTraceDomainService;

@Component
public class UpdateOrderTraceUseCase implements IUpdateOrderTraceStateUseCase{

    private final IOrderTraceDomainService orderTraceDomainService; 

    public UpdateOrderTraceUseCase(IOrderTraceDomainService orderTraceDomainService) {
        this.orderTraceDomainService = orderTraceDomainService;
    }

    @Override
    public void updateState(Long orderTraceId, States state) {
        orderTraceDomainService.addStateTrace(orderTraceId, state);
    }

}
