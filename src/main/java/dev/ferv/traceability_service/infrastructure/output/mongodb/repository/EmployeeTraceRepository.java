package dev.ferv.traceability_service.infrastructure.output.mongodb.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import dev.ferv.traceability_service.infrastructure.output.mongodb.entity.EmployeeTraceEntity;

public interface EmployeeTraceRepository extends MongoRepository<EmployeeTraceEntity, String>{

    Optional<EmployeeTraceEntity> findByEmployeeId(Long employeeId);
    List<EmployeeTraceEntity> findAllByOrderByProductiveAvarageTimeAsc();
}
