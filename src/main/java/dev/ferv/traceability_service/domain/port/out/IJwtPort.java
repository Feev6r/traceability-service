package dev.ferv.traceability_service.domain.port.out;


public interface IJwtPort {

    String extractUsername(String token);
    boolean isTokenValid(String token, String username);
    String extractRoles(String jwt);
}
