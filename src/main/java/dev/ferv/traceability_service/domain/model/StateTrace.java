package dev.ferv.traceability_service.domain.model;

import java.time.LocalDateTime;

public class StateTrace {

    States state;
    LocalDateTime completionDate;

    public StateTrace(States state, LocalDateTime completionDate) {
        this.state = state;
        this.completionDate = completionDate;
    }
    public StateTrace(States state){
        this.state = state;
        completionDate = LocalDateTime.now();
    }

    public StateTrace(){

    }
    
    public States getState() {
        return state;
    }
    public void setState(States state) {
        this.state = state;
    }
    public LocalDateTime getCompletionDate() {
        return completionDate;
    }
    public void setCompletionDate(LocalDateTime completionDate) {
        this.completionDate = completionDate;
    }
    

    

    
}
