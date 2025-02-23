package dev.ferv.traceability_service.infrastructure.output.mongodb.entity;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Document(collection = "employeeTrace")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class EmployeeTraceEntity {

    @Id
    String id;

    Long employeeId;

    List<String> ordersTraceId;
    
    String productiveAvarageTime;

}
