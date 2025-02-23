package dev.ferv.traceability_service.infrastructure.input;

import org.springframework.web.bind.annotation.RestController;

import dev.ferv.traceability_service.application.dto.request.OrderTraceRequest;
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


@RestController
@RequestMapping("orderTrace")
@RequiredArgsConstructor
public class OrderTraceController {

    private final IOrderTraceService orderTraceService;

    @PostMapping("/create")
    public ResponseEntity<Void> postMethodName(@RequestBody OrderTraceRequest orderTraceRequest) {

        orderTraceService.createOrderTrace(orderTraceRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/update/{orderTraceId}/{newState}")
    public ResponseEntity<Void> putMethodName(@PathVariable String orderTraceId, @PathVariable States newState) {

        orderTraceService.updateStates(orderTraceId, newState);
        return ResponseEntity.noContent().build();

    }
    


}
