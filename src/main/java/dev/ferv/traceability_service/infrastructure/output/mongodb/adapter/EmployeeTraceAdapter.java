package dev.ferv.traceability_service.infrastructure.output.mongodb.adapter;

import java.util.ArrayList;
import java.util.List;

import dev.ferv.traceability_service.domain.model.EmployeeTrace;
import dev.ferv.traceability_service.domain.port.out.IEmployeeTracePort;
import dev.ferv.traceability_service.infrastructure.output.mongodb.entity.EmployeeTraceEntity;
import dev.ferv.traceability_service.infrastructure.output.mongodb.entity.OrderTraceEntity;
import dev.ferv.traceability_service.infrastructure.output.mongodb.mapper.EmployeeTraceEntityMapper;
import dev.ferv.traceability_service.infrastructure.output.mongodb.repository.EmployeeTraceRepository;
import dev.ferv.traceability_service.infrastructure.output.mongodb.repository.OrderTraceRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class EmployeeTraceAdapter implements IEmployeeTracePort {

    private final EmployeeTraceRepository employeeTraceRepository; 
    private final EmployeeTraceEntityMapper employeeTraceEntityMapper;
    private final OrderTraceRepository orderTraceRepository;

    @Override
    public void createEmployeeTrace(Long employeeId, Long orderId) {

        EmployeeTraceEntity employeeTraceEntity = new EmployeeTraceEntity();
        employeeTraceEntity.setEmployeeId(employeeId);

        OrderTraceEntity orderTraceEntity = orderTraceRepository.findByOrderId(orderId)
            .orElseThrow(RuntimeException::new);

        //new list to initialize the orders ids list
        List<String> orderIds = new ArrayList<>();
        orderIds.add(orderTraceEntity.getId());

        employeeTraceEntity.setOrdersTraceId(orderIds);

        employeeTraceRepository.save(employeeTraceEntity);

    }

    @Override
    public void updateEmployeeTrace(EmployeeTrace employeeTrace, Long orderId) {
        employeeTraceRepository.save(employeeTraceEntityMapper.toEntity(employeeTrace));
    }

    @Override
    public EmployeeTrace getEmployeeTraceByEmployeeId(Long employeeId) {
        return employeeTraceEntityMapper.toEmployeeTrace(employeeTraceRepository.findByEmployeeId(employeeId)
            .orElse(null));
    }

}
