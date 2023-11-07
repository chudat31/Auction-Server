//package com.example.product.models;
//
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
//import org.springframework.beans.factory.annotation.Value;
//
//import java.util.Date;
//
//public class JwtTokenUtil {
//    private static final long  EXPIRE_DURATION = 800000000;
//
//    @Value("${app.jwt.secret}")
//    private String secretkey;
//
//    public String generateAccessToken(User user) {
//        return Jwts.builder().setSubject(user.getUsername()).setIssuer("").setIssuedAt(new Date())
//                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE_DURATION))
//                .signWith(SignatureAlgorithm.ES256, secretkey).compact();
//    }
//}
