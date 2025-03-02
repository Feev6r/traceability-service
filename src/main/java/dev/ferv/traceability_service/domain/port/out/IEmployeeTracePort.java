package dev.ferv.traceability_service.domain.port.out;

import java.util.List;

import dev.ferv.traceability_service.domain.model.EmployeeTrace;

public interface IEmployeeTracePort {

    void createEmployeeTrace(Long employeeId, Long orderId);
    void updateEmployeeTrace(EmployeeTrace employeeTrace);
    EmployeeTrace getEmployeeTraceByEmployeeId(Long employeeId);
    List<EmployeeTrace> getByProductiveTimeAsc();
}
