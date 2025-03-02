package dev.ferv.traceability_service.application.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import dev.ferv.traceability_service.application.dto.response.EmployeeTraceResponse;
import dev.ferv.traceability_service.application.mapper.EmployeeTraceMapper;
import dev.ferv.traceability_service.domain.port.in.IEmployeeTraceUpdateUseCase;
import dev.ferv.traceability_service.domain.port.in.IGetEmployeeTraceOrderByProductiveTimeUseCase;

@Service
public class EmployeeTraceService implements IEmployeeTraceService{


    private final IEmployeeTraceUpdateUseCase employeeTraceUpdateUseCase;
    private final IGetEmployeeTraceOrderByProductiveTimeUseCase getEmployeeTraceOrderByProductiveTimeUseCase;
    private final EmployeeTraceMapper employeeTraceMapper;

    public EmployeeTraceService(IEmployeeTraceUpdateUseCase employeeTraceUpdateUseCase,
            IGetEmployeeTraceOrderByProductiveTimeUseCase getEmployeeTraceOrderByProductiveTimeUseCase,
            EmployeeTraceMapper employeeTraceMapper) {
        this.employeeTraceUpdateUseCase = employeeTraceUpdateUseCase;
        this.getEmployeeTraceOrderByProductiveTimeUseCase = getEmployeeTraceOrderByProductiveTimeUseCase;
        this.employeeTraceMapper = employeeTraceMapper;
    }

    @Override
    @Transactional
    public void addOrderTrace(Long employeeId, Long orderId) {
        employeeTraceUpdateUseCase.addOrderTrace(employeeId, orderId);
    }

    @Override
    public List<EmployeeTraceResponse> getByProductiveTimeAsc(List<Long> employeesId) {
        return employeeTraceMapper.toResponseList(
            getEmployeeTraceOrderByProductiveTimeUseCase.getByProductiveTimeAsc(employeesId)
            );
    }

}
