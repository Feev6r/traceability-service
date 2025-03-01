package dev.ferv.traceability_service.application.useCase;

import org.springframework.stereotype.Component;

import dev.ferv.traceability_service.domain.port.in.IEmployeeTraceUpdateUseCase;
import dev.ferv.traceability_service.domain.service.interfaces.IEmployeeTraceDomainService;

@Component
public class EmployeeTraceUpdateUseCase implements IEmployeeTraceUpdateUseCase{

    private final IEmployeeTraceDomainService employeeTraceDomainService;
    
    public EmployeeTraceUpdateUseCase(IEmployeeTraceDomainService employeeTraceDomainService) {
        this.employeeTraceDomainService = employeeTraceDomainService;
    }

    @Override
    public void addOrderTrace(Long employeeId, Long orderId) {
        employeeTraceDomainService.addOrderToEmployeeTrace(employeeId, orderId);
    }

}
