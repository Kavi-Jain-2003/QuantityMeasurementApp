package com.apps.quantitymeasurement.security;

import java.util.Date;
import io.jsonwebtoken.security.Keys;
import java.security.Key;
import io.jsonwebtoken.*;
import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);
    

    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
                .signWith(key)
                .compact();
    }

    public String extractUsername(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(key)
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }
}
