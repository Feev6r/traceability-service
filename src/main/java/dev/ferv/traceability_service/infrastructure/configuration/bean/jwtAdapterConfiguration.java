package dev.ferv.traceability_service.infrastructure.configuration.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import dev.ferv.traceability_service.domain.port.out.IJwtPort;
import dev.ferv.traceability_service.infrastructure.output.security.adapter.JwtAdapter;

@Configuration
public class jwtAdapterConfiguration {

    @Bean
    IJwtPort jwtPort(){
        return new JwtAdapter();
    }

}
