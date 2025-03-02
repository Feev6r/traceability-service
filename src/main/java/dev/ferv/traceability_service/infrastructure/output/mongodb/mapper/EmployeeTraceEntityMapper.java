package dev.ferv.traceability_service.infrastructure.output.mongodb.mapper;


import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import dev.ferv.traceability_service.domain.model.EmployeeTrace;
import dev.ferv.traceability_service.domain.model.OrderTrace;
import dev.ferv.traceability_service.domain.port.out.IOrderTracePort;
import dev.ferv.traceability_service.infrastructure.output.mongodb.entity.EmployeeTraceEntity;

@Component
public class EmployeeTraceEntityMapper {

    private final IOrderTracePort orderTracePort;

    public EmployeeTraceEntityMapper(IOrderTracePort orderTracePort) {
        this.orderTracePort = orderTracePort;
    }

    private List<String> ordersTraceToStringIds(List<OrderTrace> orderTraces){

        List<String> orderTraceIds = new ArrayList<>();     
        if(orderTraces.isEmpty()) return orderTraceIds;
        
        for (OrderTrace orderTrace : orderTraces) {
            orderTraceIds.add(orderTrace.getId());
        }  
        return orderTraceIds;
    }

    private List<OrderTrace> stringsIdsToOrderTrace(List<String> employeeTraceIds){

        List<OrderTrace> orderTraces = new ArrayList<>();
        if(employeeTraceIds.isEmpty()) return orderTraces;


        for (String id : employeeTraceIds) {
            System.out.println(id);
            orderTraces.add(orderTracePort.getOrderById(id)); 
        }  

        return orderTraces;
    }

    public EmployeeTraceEntity toEntity(EmployeeTrace employeeTrace){
        if(employeeTrace == null){
            return null;
        }

        EmployeeTraceEntity employeeTraceEntity = new EmployeeTraceEntity();

        employeeTraceEntity.setId(employeeTrace.getId());
        employeeTraceEntity.setEmployeeId(employeeTrace.getEmployeeId());
        employeeTraceEntity.setOrdersTraceId(ordersTraceToStringIds(employeeTrace.getOrders()));
        employeeTraceEntity.setProductiveAvarageTime(employeeTrace.getProductiveAvarageTime());

        return employeeTraceEntity;

    }

    public EmployeeTrace toEmployeeTrace(EmployeeTraceEntity employeeTraceEntity){
        if(employeeTraceEntity == null){
            return null;
        }

        EmployeeTrace employeeTrace = new EmployeeTrace(
            employeeTraceEntity.getId(), 
            employeeTraceEntity.getEmployeeId(),
            stringsIdsToOrderTrace(employeeTraceEntity.getOrdersTraceId()),
            employeeTraceEntity.getProductiveAvarageTime());

        return employeeTrace;
    }

    public List<EmployeeTrace> toEmployeeTraceList(List<EmployeeTraceEntity> employeeTraceEntityList){   
        if(employeeTraceEntityList == null){
            return null;
        }

        List<EmployeeTrace> employeeTraceList = new ArrayList<>();
        for (EmployeeTraceEntity employeeTraceEntity : employeeTraceEntityList) {
            employeeTraceList.add(toEmployeeTrace(employeeTraceEntity)); 
        }

        return employeeTraceList;

    }

}
