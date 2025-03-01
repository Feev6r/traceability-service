package dev.ferv.traceability_service.infrastructure.output.mongodb.mapper.duration;

import java.time.Duration;

import org.springframework.core.convert.converter.Converter;

public class DurationToLongConverter implements Converter<Duration, Long> {

    @Override
    public Long convert(@SuppressWarnings("null") Duration source) {
        if (source == null) {
            return null; // Si el Duration es null, devuelve null
        }
        return source.toSeconds(); // Convierte Duration a milisegundos (long)
    }
}


