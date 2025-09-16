package com.cleanliness.drive.config;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;

@Component
public class JwtConfig {
    private final Key secretKey;
    public JwtConfig(){

        // Must Change before final Deployment !!
        String base64key = "9h8MP+GN+PdC0gObZfa8PmH6fv3xRlnBFP5z4OPh9PU=";

        if(base64key == null || base64key.isEmpty()){
            throw new IllegalStateException("JWT Secret key is not set");
        }
        byte[] keyBytes = Decoders.BASE64.decode(base64key);
        if(keyBytes.length != 32){
            throw new IllegalArgumentException("Invalid Key Size. Key size must be 256 bits");
        }
        this.secretKey = Keys.hmacShaKeyFor(keyBytes);
        System.out.println("Secret Key loaded successfully");
    }

    public Key getSecretKey(){
        return secretKey;
    }
}
