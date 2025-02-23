package dev.ferv.traceability_service.application.service;

import dev.ferv.traceability_service.application.dto.request.OrderTraceRequest;

public interface IOrderTraceService {

    void createOrderTrace(OrderTraceRequest orderTraceRequest);

}
