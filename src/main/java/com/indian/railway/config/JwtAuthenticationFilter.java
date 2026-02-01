package com.indian.railway.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.indian.railway.common.GenericResponse;
import io.jsonwebtoken.Claims;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;
import java.util.List;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain)
            throws ServletException, IOException {

        String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) {

            String token = header.substring(7);

            if (jwtUtil.validateToken(token)) {

                Claims claims = jwtUtil.extractAllClaims(token);

                String username = claims.getSubject();
                String role = claims.get("role", String.class);

                if (role != null) {

                    SimpleGrantedAuthority authority =
                            new SimpleGrantedAuthority("ROLE_" + role);

                    UsernamePasswordAuthenticationToken auth =
                            new UsernamePasswordAuthenticationToken(
                                    username, null, List.of(authority));

                    SecurityContextHolder.getContext().setAuthentication(auth);
                }
            }else{
                GenericResponse<String> responseBody = new GenericResponse<>(
                        "Session expired or invalid token",
                        null,
                        0,
                        HttpStatus.UNAUTHORIZED.value()
                );

                response.setStatus(HttpStatus.UNAUTHORIZED.value());
                response.setContentType("application/json");
                new ObjectMapper().writeValue(response.getOutputStream(), responseBody);
                return;
            }
        }

        filterChain.doFilter(request, response);
    }
}
