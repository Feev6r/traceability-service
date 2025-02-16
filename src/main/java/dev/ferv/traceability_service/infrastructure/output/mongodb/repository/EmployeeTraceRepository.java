package dev.ferv.traceability_service.infrastructure.output.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import dev.ferv.traceability_service.infrastructure.output.mongodb.entity.EmployeeTraceEntity;

public interface EmployeeTraceRepository extends MongoRepository<EmployeeTraceEntity, String>{

}
