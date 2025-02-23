package dev.ferv.traceability_service.application.mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import dev.ferv.traceability_service.application.dto.request.OrderTraceRequest;
import dev.ferv.traceability_service.domain.model.OrderTrace;
import dev.ferv.traceability_service.domain.model.StateTrace;

@Component
public class OrderTraceRequestMapper {

    public OrderTrace toOrderTrace(OrderTraceRequest orderTraceRequest){

        OrderTrace orderTrace = new OrderTrace();
        orderTrace.setClientId(orderTraceRequest.getClientId());
        orderTrace.setOrderId(orderTraceRequest.getOrderId());

        //create the initial state
        List<StateTrace> stateTraceList = new ArrayList<>();
        stateTraceList.add(new StateTrace(orderTraceRequest.getState()));
        orderTrace.setStates(stateTraceList);

        return orderTrace;
    }
}

