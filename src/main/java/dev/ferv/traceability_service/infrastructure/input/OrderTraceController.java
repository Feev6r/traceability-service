package dev.ferv.traceability_service.infrastructure.input;

import org.springframework.web.bind.annotation.RestController;

import dev.ferv.traceability_service.application.dto.request.OrderTraceRequest;
import dev.ferv.traceability_service.application.dto.response.OrderTraceResponse;
import dev.ferv.traceability_service.application.service.IOrderTraceService;
import dev.ferv.traceability_service.domain.model.States;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
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


    @Operation(
        description = "creates an order trace. ROLE: CLIENT",
        summary = "order creation",
        responses = {
            @ApiResponse(
                description = "Succes",
                responseCode = "200"
            ),
            @ApiResponse(
                description = "Unauthorized",
                responseCode = "403"
            )
        }
    )
    @PostMapping("/create")
    public ResponseEntity<Void> create(@RequestBody OrderTraceRequest orderTraceRequest) {

        orderTraceService.createOrderTrace(orderTraceRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @Operation(
        description = "changes a state of an order to a new one. ROLE: EMPLOYEE",
        summary = "state changing",
        responses = {
            @ApiResponse(
                description = "Succes",
                responseCode = "200"
            ),
            @ApiResponse(
                description = "Unauthorized",
                responseCode = "403"
            )
        }
    )
    @PutMapping("/update/{orderId}/{employeeId}/{newState}")
    public ResponseEntity<Void> updateToNewState(@PathVariable Long orderId, @PathVariable Long employeeId, @PathVariable States newState) {
        orderTraceService.updateStates(orderId, employeeId, newState);
        return ResponseEntity.noContent().build();

    }

    
    @Operation(
        description = "obtains the traceability of an order (processed in restaurant-service). ROLE: CLIENT",
        summary = "state changing",

        responses = {
            @ApiResponse(
                description = "Succes",
                responseCode = "200"
            ),
            @ApiResponse(
                description = "Unauthorized",
                responseCode = "403"
            )
        }
    )
    @GetMapping("/{orderId}")
    public ResponseEntity<OrderTraceResponse> getOrderTrace(@PathVariable Long orderId) {
        return ResponseEntity.ok(orderTraceService.getOrderTrace(orderId));
    }
    
    
}
