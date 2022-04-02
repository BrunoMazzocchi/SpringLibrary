package com.example.library.LibraryAPI.web.security;

import io.jsonwebtoken.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;

import java.util.*;

@Component
public class JWTUtil {
    private static final String KEY = "testing";

    public String generateToken(UserDetails userDetails){
        //Genera un JWT y lo retorna
        return Jwts.builder().setSubject(userDetails.getUsername()).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10 ))
                .signWith(SignatureAlgorithm.HS256, KEY).compact();
    }

    public boolean validateToken(String token, UserDetails userDetails){
        //Verificar que el JWT funciona y no ha expirado
        return userDetails.getUsername().equals(extractUsername(token)) && !isTokenExpired(token); //Validamos que el username es el mismo y el token es valido
    }
    public String extractUsername(String token){
        return getClaims(token).getSubject();
    }
    private boolean isTokenExpired(String token){
        return getClaims(token).getExpiration().before(new Date());
    }
    //cuando se verifique que la firma es correcta, se obtiene los objetos de JWT
    private Claims getClaims(String token){
        return Jwts.parser().setSigningKey(KEY).parseClaimsJws(token).getBody();
    }
}
