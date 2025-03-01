package dev.ferv.traceability_service.domain.port.out;

import dev.ferv.traceability_service.domain.model.OrderTrace;

public interface IOrderTracePort {

    void createOrderTrace(OrderTrace orderTrace);
    void updateOrderTrace(Long orderId, OrderTrace orderTrace); 
    OrderTrace getOrderById(String orderTraceId);
    OrderTrace getOrderTraceByOrderId(Long orderId);
}
