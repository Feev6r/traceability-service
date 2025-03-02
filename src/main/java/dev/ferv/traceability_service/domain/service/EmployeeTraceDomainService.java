package dev.ferv.traceability_service.domain.service;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
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

    @Override
    public void updateProductivityTime(Long employeeId){

        EmployeeTrace employeeTrace = employeeTracePort.getEmployeeTraceByEmployeeId(employeeId);

        List<String> orderTraceIds = getFinishedOrders(employeeTrace.getOrders());

        if(orderTraceIds.size() >= 1){
            employeeTrace.setProductiveAvarageTime(calculateProductivityTime(orderTraceIds));;
        }

        employeeTracePort.updateEmployeeTrace(employeeTrace);

    }


    private void updateEmployeeTraceOrders(EmployeeTrace employeeTrace, Long orderId){

        OrderTrace orderTrace = orderTracePort.getOrderTraceByOrderId(orderId);
        employeeTrace.getOrders().add(orderTrace);

        employeeTracePort.updateEmployeeTrace(employeeTrace);
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
    
    @Override
    public List<EmployeeTrace> getByProductiveTimeAsc(List<Long> employeeIds){
        return filterEmployeeRanking(employeeIds);
    }

    private List<EmployeeTrace> filterEmployeeRanking(List<Long> employeeIds){
        List<EmployeeTrace> employeeTraceRanking = employeeTracePort.getByProductiveTimeAsc();

        List<EmployeeTrace> filteredEmployeeTraceRanking = new ArrayList<>();

        HashMap<Long, Boolean> mp = new HashMap<>();
        for (Long id : employeeIds) mp.put(id, true);

        for (EmployeeTrace employeeTrace : employeeTraceRanking) {
            if(mp.get(employeeTrace.getEmployeeId())){
                filteredEmployeeTraceRanking.add(employeeTrace);
            }
        }

        return filteredEmployeeTraceRanking;
    }

}
