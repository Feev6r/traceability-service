package dev.ferv.traceability_service.infrastructure.configuration.security;

import java.io.IOException;
import java.util.List;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import dev.ferv.traceability_service.domain.port.out.IJwtPort;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationFilter extends OncePerRequestFilter{

    private final IJwtPort jwtPort;

    @Override
    protected void doFilterInternal(
        @SuppressWarnings("null") HttpServletRequest request, 
        @SuppressWarnings("null") HttpServletResponse response, 
        @SuppressWarnings("null") FilterChain filterChain)
            throws ServletException, IOException {

        try {

            String jwt = extractJwtFromRequest(request);

            if (jwt != null) {

                String username = jwtPort.extractUsername(jwt);
                String role = jwtPort.extractRoles(jwt);

                    UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(  
                            username, //set the username (id in this case)
                            null,
                            List.of(new SimpleGrantedAuthority("ROLE_" + role))
                    );         

                    SecurityContextHolder.getContext().setAuthentication(auth); //set it to the context
            
            }               
            else {  
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED); 
            System.out.println("NO TOKEN");
            return;
            } 
        
        }
        catch (Exception e) {
            response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE); // 503 Unavailable
            return;
        }

        filterChain.doFilter(request, response);

    }

    private String extractJwtFromRequest(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (bearerToken != null && bearerToken.startsWith("Bearer ")) {
            return bearerToken.substring(7);
        }
        return null;
    }

}
