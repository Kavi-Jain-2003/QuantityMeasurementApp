package com.app.quantitymeasurement.security;

import java.io.IOException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.*;
import jakarta.servlet.http.*;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                   HttpServletResponse response,
                                   FilterChain chain)
            throws ServletException, IOException {

        String header = request.getHeader("Authorization");

        if (header != null && header.startsWith("Bearer ")) {

            String token = header.substring(7);
            String username = jwtUtil.extractUsername(token);

            // Check if already authenticated
            if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {

                try {
                	if (jwtUtil.validateToken(token, username)) {

                	    var authToken = new UsernamePasswordAuthenticationToken(
                	            username,
                	            null,
                	            new ArrayList<>()
                	    );

                	    SecurityContextHolder.getContext().setAuthentication(authToken);
                	}

                } 
                //IMPORTANT: fallback for OAuth users not in DB
                catch (Exception e) {
                    UsernamePasswordAuthenticationToken authToken =
                        new UsernamePasswordAuthenticationToken(
                                username, null, null
                        );

                    SecurityContextHolder.getContext().setAuthentication(authToken);
                }

            }
        }

        chain.doFilter(request, response);
    }
}