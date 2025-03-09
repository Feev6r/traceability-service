package dev.ferv.traceability_service.infrastructure.output.mongodb.adapter;

import org.springframework.stereotype.Component;

import dev.ferv.traceability_service.domain.model.OrderTrace;
import dev.ferv.traceability_service.domain.port.out.IOrderTracePort;
import dev.ferv.traceability_service.infrastructure.output.mongodb.entity.OrderTraceEntity;
import dev.ferv.traceability_service.infrastructure.output.mongodb.mapper.OrderTraceEntityMapper;
import dev.ferv.traceability_service.infrastructure.output.mongodb.mapper.StateTraceEntityMapper;
import dev.ferv.traceability_service.infrastructure.output.mongodb.repository.OrderTraceRepository;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class OrderTraceAdapter implements IOrderTracePort {

    private final OrderTraceRepository orderTraceRepository;
    private final OrderTraceEntityMapper orderTraceEntityMapper;
    private final StateTraceEntityMapper stateTraceEntityMapper;

    @Override
    public void createOrderTrace(OrderTrace orderTrace) {
        orderTraceRepository.save(orderTraceEntityMapper.toEntity(orderTrace));
    }

    @Override
    public void updateOrderTrace(Long orderId, OrderTrace orderTrace) {

        OrderTraceEntity orderTraceEntity = orderTraceRepository.findByOrderId(orderId)
            .orElseThrow(() -> new RuntimeException("orderTraceEntity not found in the method updateOrderTrace()"));

        if(orderTrace.getStates() != null){
            orderTraceEntity.setStates(stateTraceEntityMapper.toEntityList(orderTrace.getStates()));
        }
        if(orderTrace.getDuration() != null){
            orderTraceEntity.setDuration(orderTrace.getDuration());
        }

        orderTraceRepository.save(orderTraceEntity);
    }

    @Override
    public OrderTrace getOrderById(String orderTraceId) {

        return orderTraceEntityMapper.toOrderTrace(orderTraceRepository.findById(orderTraceId)
            .orElseThrow(() -> new RuntimeException("orderTraceEntity not found in the method getOrderById()")));
    }

    public OrderTrace getOrderTraceByOrderId(Long orderId){
        OrderTraceEntity orderTraceEntity = orderTraceRepository.findByOrderId(orderId)
            .orElseThrow(() -> new RuntimeException("orderTraceEntity not found in the method getOrderTraceByOrderId()"));

        return orderTraceEntityMapper.toOrderTrace(orderTraceEntity);
    } 
}
