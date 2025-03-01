package dev.ferv.traceability_service.domain.service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import dev.ferv.traceability_service.domain.model.EmployeeTrace;
import dev.ferv.traceability_service.domain.model.OrderTrace;
import dev.ferv.traceability_service.domain.model.States;
import dev.ferv.traceability_service.domain.port.out.IEmployeeTracePort;
import dev.ferv.traceability_service.domain.port.out.IOrderTracePort;
import dev.ferv.traceability_service.domain.service.interfaces.IEmployeeTraceDomainService;

public class EmployeeTraceDomainService implements IEmployeeTraceDomainService {

    private final IEmployeeTracePort employeeTracePort;
    private final IOrderTracePort orderTracePort;

    public EmployeeTraceDomainService(IEmployeeTracePort employeeTracePort, IOrderTracePort orderTracePort) {
        this.employeeTracePort = employeeTracePort;
        this.orderTracePort = orderTracePort;
    }

    private List<String> getFinishedOrders(List<OrderTrace> orderTraces){

        List<String> finishedOrderIds = new ArrayList<>();
        for (OrderTrace orderTrace : orderTraces) {
            if(orderTrace.getStates().getLast().getState() == States.DELIVERED){
                finishedOrderIds.add(orderTrace.getId());
            }
        }

        return finishedOrderIds;
    }

    private Duration calculateProductivityTime(List<String> finishedOrderIds){
        
        Long totalSeconds = 0L;

        for (String id : finishedOrderIds) {
            totalSeconds += orderTracePort.getOrderById(id).getDuration().getSeconds();
        }

        Long avarageSeconds = totalSeconds / finishedOrderIds.size();
        Duration avarageTime = Duration.ofSeconds(avarageSeconds);

        return avarageTime;
    }

    private void updateEmployeeTraceOrders(EmployeeTrace employeeTrace, Long orderId){

        List<String> orderTraceIds = getFinishedOrders(employeeTrace.getOrders());

        if(orderTraceIds.size() >= 1){
            employeeTrace.setProductiveAvarageTime(calculateProductivityTime(orderTraceIds));;
        }

        OrderTrace orderTrace = orderTracePort.getOrderTraceByOrderId(orderId);
        employeeTrace.getOrders().add(orderTrace);

        employeeTracePort.updateEmployeeTrace(employeeTrace, orderId);
    }
    
    private void createEmployeeTrace(Long employeeId, Long orderId){
        employeeTracePort.createEmployeeTrace(employeeId, orderId);
    }

    @Override
    public void addOrderToEmployeeTrace(Long employeeId, Long orderId) {

        EmployeeTrace employeeTrace = employeeTracePort.getEmployeeTraceByEmployeeId(employeeId);

        if(employeeTrace == null)
            createEmployeeTrace(employeeId, orderId);
        else
            updateEmployeeTraceOrders(employeeTrace, orderId);
        
    }

    // public List<EmployeeTrace> getRankingByProductivityTime(){
        //TODO MAKE getRankingByProductivityTime RIGH NOW
    // }

}
