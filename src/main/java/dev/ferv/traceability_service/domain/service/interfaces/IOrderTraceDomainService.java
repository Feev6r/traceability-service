package dev.ferv.traceability_service.domain.service.interfaces;

import java.time.Duration;
import java.util.List;

import dev.ferv.traceability_service.domain.model.StateTrace;
import dev.ferv.traceability_service.domain.model.States;

public interface IOrderTraceDomainService {
    Duration calculateDuration(List<StateTrace> states);
    void addStateTrace(Long orderId, States state);
}
