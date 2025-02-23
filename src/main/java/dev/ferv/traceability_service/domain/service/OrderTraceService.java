package dev.ferv.traceability_service.domain.service;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.List;

import dev.ferv.traceability_service.domain.model.StateTrace;

public class OrderTraceService {


    public Duration calculateDuration(List<StateTrace> states) {
        if (states == null) {
            throw new IllegalArgumentException("The order state has to be delivered to calculate the final time duration of the order");
        }

        LocalDateTime startDate = states.get(0).getCompletionDate();
        LocalDateTime endDate = states.get(states.size() - 1).getCompletionDate();

        return Duration.between(startDate, endDate);
    }

}
