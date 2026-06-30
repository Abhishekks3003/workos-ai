package com.dev.workos.auth.jwt;

import java.util.Date;
import com.dev.workos.auth.entity.User;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;

@Service
public class JwtService {

    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private long jwtExpiration;

    //for convert secret key to byte string
    private SecretKey getSignInKey() {

        byte[] keyBytes =
                //cryptograhic ops requires bytes not string
                Decoders.BASE64.decode(secretKey);

        return Keys.hmacShaKeyFor(keyBytes); //bytes to cryptographic key obj
    }

    public String generateToken(User user) {

        return Jwts
                .builder()
                .subject(user.getEmail())
                .issuedAt(new Date())
                .expiration(new Date(
                        System.currentTimeMillis() + jwtExpiration
                ))
                .signWith(getSignInKey()) //HMAC SHA algorithm
                .compact();  //combines header+payload+signature

    }

    public String extractUsername(String token) {

        return Jwts
                .parser()
                .verifyWith(getSignInKey())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();

    }

    public boolean isTokenValid(String token, User user) {

        String email = extractUsername(token);

        return email.equals(user.getEmail());

    }

}