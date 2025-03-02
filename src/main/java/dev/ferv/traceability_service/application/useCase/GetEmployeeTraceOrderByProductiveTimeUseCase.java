package dev.ferv.traceability_service.application.useCase;

import java.util.List;

import org.springframework.stereotype.Component;

import dev.ferv.traceability_service.domain.model.EmployeeTrace;
import dev.ferv.traceability_service.domain.port.in.IGetEmployeeTraceOrderByProductiveTimeUseCase;
import dev.ferv.traceability_service.domain.service.interfaces.IEmployeeTraceDomainService;

@Component
public class GetEmployeeTraceOrderByProductiveTimeUseCase implements IGetEmployeeTraceOrderByProductiveTimeUseCase{


    private final IEmployeeTraceDomainService employeeTraceDomainService;

    public GetEmployeeTraceOrderByProductiveTimeUseCase(IEmployeeTraceDomainService employeeTraceDomainService) {
        this.employeeTraceDomainService = employeeTraceDomainService;
    }

    @Override
    public List<EmployeeTrace> getByProductiveTimeAsc(List<Long> employeeIds) {
        return employeeTraceDomainService.getByProductiveTimeAsc(employeeIds);
    }

}
