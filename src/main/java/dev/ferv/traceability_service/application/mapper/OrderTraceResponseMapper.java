package dev.ferv.traceability_service.application.mapper;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import dev.ferv.traceability_service.application.dto.response.OrderTraceResponse;
import dev.ferv.traceability_service.application.dto.response.StateTraceResponse;
import dev.ferv.traceability_service.domain.model.OrderTrace;
import dev.ferv.traceability_service.domain.model.StateTrace;

@Component
public class OrderTraceResponseMapper {

    private String toReadableTime(Duration duration){
        long totalSeconds = duration.getSeconds();

        long hours = totalSeconds / 3600;
        long minutes = (totalSeconds % 3600) / 60;
        long seconds = totalSeconds % 60;

        String legible = String.format("%d horas, %d minutos, %d segundos", 
                                      hours, minutes, seconds);

        return legible;
    }

    private String toReadableDate(LocalDateTime localDateTime){

        DateTimeFormatter conMes = DateTimeFormatter.ofPattern("dd MMMM yyyy HH:mm");
        String readable = localDateTime.format(conMes); 

        return readable;
    }

    public StateTraceResponse toStateTraceResponse(StateTrace stateTrace){
        if(stateTrace == null){
            return null;
        }

        StateTraceResponse stateTraceResponse = new StateTraceResponse(
            stateTrace.getState(),
            toReadableDate(stateTrace.getCompletionDate())
        );
    
        return stateTraceResponse;
    }

    public List<StateTraceResponse> toStateTraceResponseList(List<StateTrace> stateTraceList){

        List<StateTraceResponse> stateTraceResponseList = new ArrayList<>();

        for (StateTrace stateTrace : stateTraceList) {
            stateTraceResponseList.add(toStateTraceResponse(stateTrace));
        }

        return stateTraceResponseList;
    }


    public OrderTraceResponse toResponse(OrderTrace orderTrace){
        if(orderTrace == null){
            return null;
        }

        OrderTraceResponse orderTraceResponse = new OrderTraceResponse();
        orderTraceResponse.setOrderId(orderTrace.getOrderId());
        orderTraceResponse.setStates(toStateTraceResponseList(orderTrace.getStates()));
        if(orderTrace.getDuration() != null) orderTraceResponse.setDuration(toReadableTime( orderTrace.getDuration()));

        return orderTraceResponse;

    }

}
