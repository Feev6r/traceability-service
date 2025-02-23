package dev.ferv.traceability_service.application.service;

import org.springframework.stereotype.Service;

import dev.ferv.traceability_service.application.dto.request.OrderTraceRequest;
import dev.ferv.traceability_service.application.mapper.OrderTraceRequestMapper;
import dev.ferv.traceability_service.domain.model.OrderTrace;
import dev.ferv.traceability_service.domain.port.in.ICreateOrderTraceUseCase;


@Service
public class OrderTraceService implements IOrderTraceService{

    private final ICreateOrderTraceUseCase createOrderTraceUseCase;
    private final OrderTraceRequestMapper orderTraceRequestMapper;

    public OrderTraceService(ICreateOrderTraceUseCase createOrderTraceUseCase,
                OrderTraceRequestMapper orderTraceRequestMapper) {
            this.createOrderTraceUseCase = createOrderTraceUseCase;
            this.orderTraceRequestMapper = orderTraceRequestMapper;
        }

    @Override
    public void createOrderTrace(OrderTraceRequest orderTraceRequest) {
        OrderTrace orderTrace = orderTraceRequestMapper.toOrderTrace(orderTraceRequest);
        createOrderTraceUseCase.createOrderTrace(orderTrace);
    }

}
