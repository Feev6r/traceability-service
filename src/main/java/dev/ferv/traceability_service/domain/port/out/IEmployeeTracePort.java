package dev.ferv.traceability_service.domain.port.out;

import dev.ferv.traceability_service.domain.model.EmployeeTrace;

public interface IEmployeeTracePort {

    void createEmployeeTrace(Long employeeId, Long orderId);
    void updateEmployeeTrace(EmployeeTrace employeeTrace, Long orderId); 
    EmployeeTrace getEmployeeTraceByEmployeeId(Long employeeId);
}
