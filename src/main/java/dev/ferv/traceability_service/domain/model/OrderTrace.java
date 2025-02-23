package dev.ferv.traceability_service.domain.model;

import java.time.Duration;
import java.util.List;


public class OrderTrace {

    private String id;
    private List<StateTrace> states;
    private Long clientId;
    private Long orderId;
    private Duration duration; 

    
    public OrderTrace(String id, List<StateTrace> states, Long clientId, Long orderId, Duration duration) {
        this.id = id;
        this.states = states;
        this.clientId = clientId;
        this.orderId = orderId;
        this.duration = duration;
    }


    public OrderTrace(){}

    
    public List<StateTrace> getStates() {
        return states;
    }
    public void setStates(List<StateTrace> states) {
        this.states = states;
    }

    public Long getClientId() {
        return clientId;
    }

    public void setClientId(Long clientId) {
        this.clientId = clientId;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }


    public Duration getDuration() {
        return duration;
    }


    public void setDuration(Duration duration) {
        this.duration = duration;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }

    
}
