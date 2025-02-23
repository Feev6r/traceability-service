package dev.ferv.traceability_service.infrastructure.output.mongodb.mapper;


import org.mapstruct.Mapper;
import dev.ferv.traceability_service.domain.model.OrderTrace;
import dev.ferv.traceability_service.infrastructure.output.mongodb.entity.OrderTraceEntity;

@Mapper(componentModel = "spring", uses = StateTraceEntityMapper.class)
public interface OrderTraceEntityMapper {

    OrderTrace toOrderTrace(OrderTraceEntity orderTraceEntity);
    OrderTraceEntity toEntity(OrderTrace orderTrace);
}
