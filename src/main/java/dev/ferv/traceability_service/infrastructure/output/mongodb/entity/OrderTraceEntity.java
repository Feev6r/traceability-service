package dev.ferv.traceability_service.infrastructure.output.mongodb.entity;

import java.time.Duration;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


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

    Long clientId;
    Long orderId;

    List<StateTraceEntity> states;

    @Field(name = "DuarationInSeconds")
    Duration duration; 
}
