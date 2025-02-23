package dev.ferv.traceability_service.infrastructure.configuration.mongodb;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

import dev.ferv.traceability_service.infrastructure.output.mongodb.mapper.duration.DurationToLongConverter;
import dev.ferv.traceability_service.infrastructure.output.mongodb.mapper.duration.LongToDurationConverter;

@Configuration
public class MongoConfig {

 @Bean
    MongoCustomConversions mongoCustomConversions() {
        return new MongoCustomConversions(Arrays.asList(
            new DurationToLongConverter(),
            new LongToDurationConverter()
        ));
    }
}
