package dev.ferv.traceability_service.infrastructure.output.mongodb.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import dev.ferv.traceability_service.infrastructure.output.mongodb.entity.OrderTraceEntity;

public interface OrderTraceRepository extends MongoRepository<OrderTraceEntity, String>{

}
