package dev.ferv.traceability_service.domain.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import dev.ferv.traceability_service.domain.model.OrderTrace;
import dev.ferv.traceability_service.domain.model.StateTrace;
import dev.ferv.traceability_service.domain.model.States;
import dev.ferv.traceability_service.domain.port.out.IOrderTracePort;
import dev.ferv.traceability_service.domain.service.interfaces.IOrderTraceDomainService;

public class OrderTraceDomainService implements IOrderTraceDomainService{

    private final IOrderTracePort orderTracePort;

    public OrderTraceDomainService(IOrderTracePort orderTracePort) {
        this.orderTracePort = orderTracePort;
    }

    @Override
    public Duration calculateDuration(List<StateTrace> states) {
        if (states == null || states.get(states.size() -1).getState() != States.DELIVERED) {
            throw new IllegalArgumentException("The order state has to be delivered to calculate the final time duration of the order");
        }

        LocalDateTime startDate = states.get(0).getCompletionDate();
        LocalDateTime endDate = states.get(states.size() - 1).getCompletionDate();

        return Duration.between(startDate, endDate);
    }

    @Override
    public void addStateTrace(Long orderId, States state){
        StateTrace stateTrace = new StateTrace(state);

        OrderTrace orderTrace = orderTracePort.getOrderTraceByOrderId(orderId);
        orderTrace.getStates().add(stateTrace);

        if(state == States.DELIVERED){
            Duration totalDuration = calculateDuration(orderTrace.getStates());
            orderTrace.setDuration(totalDuration);
        }

        orderTracePort.updateOrderTrace(orderId, orderTrace);
    }

}
