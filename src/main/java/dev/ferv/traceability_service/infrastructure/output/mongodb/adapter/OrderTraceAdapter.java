package dev.ferv.traceability_service.infrastructure.output.mongodb.adapter;

import org.springframework.stereotype.Component;

import dev.ferv.traceability_service.domain.model.OrderTrace;
import dev.ferv.traceability_service.domain.model.StateTrace;
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
    public void updateOrderTrace(String orderTraceId, StateTrace orderTrace) {

        OrderTraceEntity orderTraceEntity = orderTraceRepository.findById(orderTraceId)
            .orElseThrow(RuntimeException::new);

        orderTraceEntity.getStates().add(stateTraceEntityMapper.toEntity(orderTrace));

        orderTraceRepository.save(orderTraceEntity);
    }

    
}
