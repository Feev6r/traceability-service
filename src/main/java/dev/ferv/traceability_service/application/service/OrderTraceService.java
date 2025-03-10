package dev.ferv.traceability_service.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.ferv.traceability_service.application.dto.request.OrderTraceRequest;
import dev.ferv.traceability_service.application.dto.response.OrderTraceResponse;
import dev.ferv.traceability_service.application.mapper.OrderTraceRequestMapper;
import dev.ferv.traceability_service.application.mapper.OrderTraceResponseMapper;
import dev.ferv.traceability_service.domain.model.OrderTrace;
import dev.ferv.traceability_service.domain.model.States;
import dev.ferv.traceability_service.domain.port.in.ICreateOrderTraceUseCase;
import dev.ferv.traceability_service.domain.port.in.IGetOrderTraceUseCase;
import dev.ferv.traceability_service.domain.port.in.IUpdateOrderTraceStateUseCase;


@Service
public class OrderTraceService implements IOrderTraceService{

    private final ICreateOrderTraceUseCase createOrderTraceUseCase;
    private final OrderTraceRequestMapper orderTraceRequestMapper;
    private final IUpdateOrderTraceStateUseCase updateOrderTraceStateUseCase;
    private final IGetOrderTraceUseCase getOrderTraceUseCase;
    private final OrderTraceResponseMapper orderTraceResponseMapper;

    public OrderTraceService(ICreateOrderTraceUseCase createOrderTraceUseCase,
            OrderTraceRequestMapper orderTraceRequestMapper, IUpdateOrderTraceStateUseCase updateOrderTraceStateUseCase,
            IGetOrderTraceUseCase getOrderTraceUseCase, OrderTraceResponseMapper orderTraceResponseMapper) {
        this.createOrderTraceUseCase = createOrderTraceUseCase;
        this.orderTraceRequestMapper = orderTraceRequestMapper;
        this.updateOrderTraceStateUseCase = updateOrderTraceStateUseCase;
        this.getOrderTraceUseCase = getOrderTraceUseCase;
        this.orderTraceResponseMapper = orderTraceResponseMapper;
    }

    @Override
    @Transactional
    public void createOrderTrace(OrderTraceRequest orderTraceRequest) {
        OrderTrace orderTrace = orderTraceRequestMapper.toOrderTrace(orderTraceRequest);
        createOrderTraceUseCase.createOrderTrace(orderTrace);
    }

    @Override
    @Transactional
    public void updateStates(Long orderTraceId, Long employeeId, States state) {
        updateOrderTraceStateUseCase.updateState(orderTraceId, employeeId, state);
    }

    @Override
    public OrderTraceResponse getOrderTrace(Long orderId){
        return orderTraceResponseMapper.toResponse(getOrderTraceUseCase.getOrderTrace(orderId));
    }

}
