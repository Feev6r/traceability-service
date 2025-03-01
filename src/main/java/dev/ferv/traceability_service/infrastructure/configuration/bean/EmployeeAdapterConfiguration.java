package dev.ferv.traceability_service.infrastructure.configuration.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.ferv.traceability_service.domain.port.out.IEmployeeTracePort;
import dev.ferv.traceability_service.infrastructure.output.mongodb.adapter.EmployeeTraceAdapter;
import dev.ferv.traceability_service.infrastructure.output.mongodb.mapper.EmployeeTraceEntityMapper;
import dev.ferv.traceability_service.infrastructure.output.mongodb.repository.EmployeeTraceRepository;
import dev.ferv.traceability_service.infrastructure.output.mongodb.repository.OrderTraceRepository;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class EmployeeAdapterConfiguration {


    private final EmployeeTraceRepository employeeTraceRepository;
    private final EmployeeTraceEntityMapper employeeTraceEntityMapper;
    private final OrderTraceRepository orderTraceRepository;

    @Bean
    IEmployeeTracePort employeeTracePort(){
        return new EmployeeTraceAdapter(employeeTraceRepository, employeeTraceEntityMapper, orderTraceRepository);
    }

}
