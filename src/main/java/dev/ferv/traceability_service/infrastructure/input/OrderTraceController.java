package dev.ferv.traceability_service.infrastructure.input;

import org.springframework.web.bind.annotation.RestController;

import dev.ferv.traceability_service.application.dto.request.OrderTraceRequest;
import dev.ferv.traceability_service.application.dto.response.OrderTraceResponse;
import dev.ferv.traceability_service.application.service.IOrderTraceService;
import dev.ferv.traceability_service.domain.model.States;
import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("orderTrace")
@RequiredArgsConstructor
public class OrderTraceController {

    private final IOrderTraceService orderTraceService;

    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody OrderTraceRequest orderTraceRequest) {

        orderTraceService.createOrderTrace(orderTraceRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update/{orderId}/{employeeId}/{newState}")
    public ResponseEntity<Void> updateToNewState(@PathVariable Long orderId, @PathVariable Long employeeId, @PathVariable States newState) {
        orderTraceService.updateStates(orderId, employeeId, newState);
        return ResponseEntity.noContent().build();

    }

    @GetMapping("/{orderId}")
    public ResponseEntity<OrderTraceResponse> getOrderTrace(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderTraceService.getOrderTrace(orderId));
    }
    
    


}
