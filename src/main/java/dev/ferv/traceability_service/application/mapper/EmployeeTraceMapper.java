package dev.ferv.traceability_service.application.mapper;

import java.time.Duration;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import dev.ferv.traceability_service.application.dto.response.EmployeeTraceResponse;
import dev.ferv.traceability_service.domain.model.EmployeeTrace;

@Mapper(componentModel = "spring")
public interface EmployeeTraceMapper {

    @Mapping(target = "productiveAvarageTime", qualifiedByName = "toReadableTimeString")
    EmployeeTraceResponse toResponse(EmployeeTrace employeeTrace);
    
    List<EmployeeTraceResponse> toResponseList(List<EmployeeTrace> employeeTraceList);


    @Named("toReadableTimeString")
    static String toReadableTime(Duration duration){
        long totalSeconds = duration.getSeconds();

        long hours = totalSeconds / 3600;
        long minutes = (totalSeconds % 3600) / 60;
        long seconds = totalSeconds % 60;

        String legible = String.format("%d horas, %d minutos, %d segundos", 
                                      hours, minutes, seconds);

        return legible;
    }
}
