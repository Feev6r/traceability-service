package dev.ferv.traceability_service.infrastructure.input;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.ferv.traceability_service.application.service.IEmployeeTraceService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("employeeTrace")
@RequiredArgsConstructor
public class EmployeeTraceController {

    private final IEmployeeTraceService employeeTraceService;

    @PutMapping("sign/{orderId}/{employeeId}")
    public ResponseEntity<Void> signOrder(@PathVariable Long orderId, @PathVariable Long employeeId) {
        employeeTraceService.addOrderTrace(employeeId, orderId);
        return ResponseEntity.noContent().build();

    }

}
