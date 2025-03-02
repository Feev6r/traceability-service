package dev.ferv.traceability_service.application.service;

import java.util.List;

import dev.ferv.traceability_service.application.dto.response.EmployeeTraceResponse;

public interface IEmployeeTraceService {

    void addOrderTrace(Long employeeId, Long orderId);
    List<EmployeeTraceResponse> getByProductiveTimeAsc(List<Long> employeesIds);

}
