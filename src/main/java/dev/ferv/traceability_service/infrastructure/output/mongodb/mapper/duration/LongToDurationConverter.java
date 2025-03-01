package dev.ferv.traceability_service.infrastructure.output.mongodb.mapper.duration;

import java.time.Duration;

import org.springframework.core.convert.converter.Converter;

public class LongToDurationConverter  implements Converter<Long, Duration>{

    @Override
    public Duration convert(@SuppressWarnings("null") Long source) {
        if (source == null) {
            return null; // Si el Duration es null, devuelve null
        }
        return Duration.ofSeconds(source); // Convierte milisegundos (long) a Duration
    }

}
