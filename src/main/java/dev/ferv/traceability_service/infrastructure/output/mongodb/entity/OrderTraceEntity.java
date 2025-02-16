package dev.ferv.traceability_service.infrastructure.output.mongodb.entity;

import java.time.Duration;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;


import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "orderTrace")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class OrderTraceEntity {

    @Id
    String id;

    Long orderId;

    List<StateEntity> states;

    Duration time; //cambiar futuramente

    @DBRef
    EmployeeTraceEntity employeeTrace;

}
