package dev.ferv.traceability_service.infrastructure.configuration.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import dev.ferv.traceability_service.domain.model.Roles;
import lombok.RequiredArgsConstructor;

@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf
            .disable()
            )
            .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/orderTrace/create").hasRole(Roles.CLIENT.name())
                .requestMatchers("/orderTrace/update").hasRole(Roles.EMPLOYEE.name())
                .requestMatchers("/employeeTrace/sign/{orderId}/{employeeId}").hasRole(Roles.EMPLOYEE.name())
                .requestMatchers("/employeeTrace/getRanking").hasRole(Roles.OWNER.name())
                .anyRequest().authenticated()
            )
            .sessionManagement(session -> session
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)   
            )
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class
            );

        return http.build();
    }

}
