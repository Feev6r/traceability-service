package dev.ferv.traceability_service.domain.port.in;

import java.util.List;

import dev.ferv.traceability_service.domain.model.EmployeeTrace;

public interface IGetEmployeeTraceOrderByProductiveTimeUseCase {
    List<EmployeeTrace> getByProductiveTimeAsc(List<Long> employeeIds);
}
