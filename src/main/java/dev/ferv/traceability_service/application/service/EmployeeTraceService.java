package dev.ferv.traceability_service.application.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.ferv.traceability_service.domain.port.in.IEmployeeTraceUpdateUseCase;

@Service
public class EmployeeTraceService implements IEmployeeTraceService{


    private final IEmployeeTraceUpdateUseCase employeeTraceUpdateUseCase;

    public EmployeeTraceService(IEmployeeTraceUpdateUseCase employeeTraceUpdateUseCase) {
        this.employeeTraceUpdateUseCase = employeeTraceUpdateUseCase;
    }

    @Override
    @Transactional
    public void addOrderTrace(Long employeeId, Long orderId) {
        employeeTraceUpdateUseCase.addOrderTrace(employeeId, orderId);
    }

}
