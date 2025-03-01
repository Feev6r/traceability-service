package dev.ferv.traceability_service.domain.model;

import java.time.Duration;
import java.util.List;

public class EmployeeTrace {

    private String id;
    private Long employeeId;
    private List<OrderTrace> orders;
    private Duration productiveAvarageTime;  
    
    public EmployeeTrace(String id, Long employeeId, List<OrderTrace> orders, Duration productiveAvarageTime) {
        this.id = id;
        this.employeeId = employeeId;
        this.orders = orders;
        this.productiveAvarageTime = productiveAvarageTime;
    }

    public EmployeeTrace(Builder builder){
        this.id = builder.id;
        this.employeeId = builder.employeeId;
        this.orders = builder.orders;
        this.productiveAvarageTime = builder.productiveAvarageTime;
    }

    public List<OrderTrace> getOrders() {
        return orders;
    }
    public void setOrders(List<OrderTrace> orders) {
        this.orders = orders;
    }
    public Duration getProductiveAvarageTime() {
        return productiveAvarageTime;
    }
    public void setProductiveAvarageTime(Duration productiveAvarageTime) {
        this.productiveAvarageTime = productiveAvarageTime;
    }
    public Long getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    //JUST TESTING BUILDER PATTERN---------------
    
    public static class Builder {

        private String id;
        private Long employeeId;
        private List<OrderTrace> orders;
        private Duration productiveAvarageTime;  
    
        public Builder(List<OrderTrace> orders, Long employeeId) {
            this.orders = orders;
            this.employeeId = employeeId;
        }
    
        public Builder id(String id) {
            this.id = id;
            return this;
        }
    
        public Builder productiveAvarageTime(Duration productiveAvarageTime) {
            this.productiveAvarageTime = productiveAvarageTime;
            return this;
        }
    

        public EmployeeTrace build() {
            return new EmployeeTrace(this);
        }
    
    }

}

