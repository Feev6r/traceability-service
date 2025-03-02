package dev.ferv.traceability_service.application.dto.response;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class OrderTraceResponse {

    private Long orderId;
    private List<StateTraceResponse> states;
    private String duration; 

}
