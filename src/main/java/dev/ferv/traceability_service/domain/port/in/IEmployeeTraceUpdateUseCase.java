package dev.ferv.traceability_service.domain.port.in;

public interface IEmployeeTraceUpdateUseCase {

    void addOrderTrace(Long employeeId, Long orderId);

}
