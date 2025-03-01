package dev.ferv.traceability_service.infrastructure.configuration.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.ferv.traceability_service.domain.port.out.IOrderTracePort;
import dev.ferv.traceability_service.infrastructure.output.mongodb.adapter.OrderTraceAdapter;
import dev.ferv.traceability_service.infrastructure.output.mongodb.mapper.OrderTraceEntityMapper;
import dev.ferv.traceability_service.infrastructure.output.mongodb.mapper.StateTraceEntityMapper;
import dev.ferv.traceability_service.infrastructure.output.mongodb.repository.OrderTraceRepository;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor 
public class OrderConfiguration {

    private final OrderTraceRepository orderTraceRepository;
    private final OrderTraceEntityMapper orderTraceEntityMapper;
    private final StateTraceEntityMapper stateTraceEntityMapper;

    @Bean
    IOrderTracePort orderTracePort(){
        return new OrderTraceAdapter(orderTraceRepository, orderTraceEntityMapper, stateTraceEntityMapper);
    }

}
