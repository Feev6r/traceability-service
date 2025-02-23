package dev.ferv.traceability_service.infrastructure.configuration.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.ferv.traceability_service.domain.port.out.IEmployeeTracePort;
import dev.ferv.traceability_service.domain.port.out.IJwtPort;
import dev.ferv.traceability_service.domain.port.out.IOrderTracePort;
import dev.ferv.traceability_service.infrastructure.output.mongodb.adapter.EmployeeTraceAdapter;
import dev.ferv.traceability_service.infrastructure.output.mongodb.adapter.OrderTraceAdapter;
import dev.ferv.traceability_service.infrastructure.output.mongodb.mapper.OrderTraceEntityMapper;
import dev.ferv.traceability_service.infrastructure.output.mongodb.repository.OrderTraceRepository;
import dev.ferv.traceability_service.infrastructure.output.security.adapter.JwtAdapter;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor 
public class AdapterConfiguration {

    private final OrderTraceRepository orderTraceRepository;
    private final OrderTraceEntityMapper orderTraceEntityMapper;

    @Bean
    IOrderTracePort orderTracePort(){
        return new OrderTraceAdapter(orderTraceRepository, orderTraceEntityMapper);
    }

    @Bean
    IEmployeeTracePort employeeTracePort(){
        return new EmployeeTraceAdapter();
    }

    @Bean
    IJwtPort jwtPort(){
        return new JwtAdapter();
    }

}
