package dev.ferv.traceability_service.domain.service.interfaces;

import java.util.List;

import dev.ferv.traceability_service.domain.model.EmployeeTrace;

public interface IEmployeeTraceDomainService {


    void addOrderToEmployeeTrace(Long employeeId, Long orderId);
    List<EmployeeTrace> getByProductiveTimeAsc(List<Long> employeeIds);
    void updateProductivityTime(Long employeeId);
}
