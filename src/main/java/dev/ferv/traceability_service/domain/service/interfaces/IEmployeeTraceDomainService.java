package dev.ferv.traceability_service.domain.service.interfaces;


public interface IEmployeeTraceDomainService {


    void addOrderToEmployeeTrace(Long employeeId, Long orderId);

}
