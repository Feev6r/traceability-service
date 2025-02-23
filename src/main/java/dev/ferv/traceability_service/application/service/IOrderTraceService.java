package dev.ferv.traceability_service.application.service;


import dev.ferv.traceability_service.application.dto.request.OrderTraceRequest;
import dev.ferv.traceability_service.domain.model.States;

public interface IOrderTraceService {

    void createOrderTrace(OrderTraceRequest orderTraceRequest);
    void updateStates(String orderTraceId, States state);

}
