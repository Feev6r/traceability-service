package dev.ferv.traceability_service.infrastructure.configuration.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.ferv.traceability_service.domain.port.out.IEmployeeTracePort;
import dev.ferv.traceability_service.domain.port.out.IOrderTracePort;
import dev.ferv.traceability_service.domain.service.EmployeeTraceDomainService;
import dev.ferv.traceability_service.domain.service.OrderTraceDomainService;
import dev.ferv.traceability_service.domain.service.interfaces.IEmployeeTraceDomainService;
import dev.ferv.traceability_service.domain.service.interfaces.IOrderTraceDomainService;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class ServiceConfiguration {

    private final IEmployeeTracePort employeeTracePort;
    private final IOrderTracePort orderTracePort;

    @Bean
    IOrderTraceDomainService orderTraceDomainService(){
        return new OrderTraceDomainService(orderTracePort);
    }

    @Bean
    IEmployeeTraceDomainService  employeeTraceDomainService(){
        return new EmployeeTraceDomainService(employeeTracePort, orderTracePort);
    }
}
