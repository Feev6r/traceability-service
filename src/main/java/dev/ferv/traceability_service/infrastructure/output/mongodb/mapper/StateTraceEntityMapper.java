package dev.ferv.traceability_service.infrastructure.output.mongodb.mapper;

import java.util.List;

import org.mapstruct.Mapper;

import dev.ferv.traceability_service.domain.model.StateTrace;
import dev.ferv.traceability_service.infrastructure.output.mongodb.entity.StateTraceEntity;

@Mapper(componentModel = "spring")
public interface StateTraceEntityMapper {

    StateTrace toStateTrace(StateTraceEntity stateTraceEntity);
    StateTraceEntity toEntity(StateTrace stateTrace);
    List<StateTraceEntity> toEntityList(List<StateTrace> stateTraces);

}
