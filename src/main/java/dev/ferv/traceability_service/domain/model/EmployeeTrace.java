package dev.ferv.traceability_service.domain.model;

import java.util.List;

public class EmployeeTrace {

    Long id;
    Long employeeId;
    List<OrderTrace> orders;
    String productiveAvarageTime;  
    
    public EmployeeTrace(Long id, Long employeeId, List<OrderTrace> orders, String productiveAvarageTime) {
        this.id = id;
        this.employeeId = employeeId;
        this.orders = orders;
        this.productiveAvarageTime = productiveAvarageTime;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public List<OrderTrace> getOrders() {
        return orders;
    }
    public void setOrders(List<OrderTrace> orders) {
        this.orders = orders;
    }
    public String getProductiveAvarageTime() {
        return productiveAvarageTime;
    }
    public void setProductiveAvarageTime(String productiveAvarageTime) {
        this.productiveAvarageTime = productiveAvarageTime;
    }
    public Long getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }

}
