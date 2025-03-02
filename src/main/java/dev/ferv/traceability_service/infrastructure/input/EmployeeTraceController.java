package dev.ferv.traceability_service.infrastructure.input;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.ferv.traceability_service.application.dto.response.EmployeeTraceResponse;
import dev.ferv.traceability_service.application.service.IEmployeeTraceService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("employeeTrace")
@RequiredArgsConstructor
public class EmployeeTraceController {

    private final IEmployeeTraceService employeeTraceService;

    @PutMapping("/sign/{orderId}/{employeeId}")
    public ResponseEntity<Void> signOrder(@PathVariable Long orderId, @PathVariable Long employeeId) {
        employeeTraceService.addOrderTrace(employeeId, orderId);
        return ResponseEntity.noContent().build();

    }

    @PostMapping("/getRanking")
    public ResponseEntity<List<EmployeeTraceResponse>> getEmployeesByProductivity(@RequestBody List<Long> employeeIds) {
        return ResponseEntity.ok(employeeTraceService.getByProductiveTimeAsc(employeeIds));
    }
    

}
