package dev.ferv.traceability_service.application.dto.response;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class OrderTraceResponse {

    private Long orderId;
    private List<StateTraceResponse> states;
    private String duration; 

}
