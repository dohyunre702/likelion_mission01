package com.example.dhlee.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;
//토큰 발급, 자격증명 관리
public class JwtTokenUtil {
    public static String createToken(String userName, String key, long expireTimeMs) {
        Claims claims = Jwts.claims();
        claims.put("username", userName);

        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + expireTimeMs))
                .signWith(SignatureAlgorithm.HS256, key)
                .compact();
    }

    //token에서 secretKey 받아와 인증
    private static Claims extractClaims(String token, String secretKey) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody();
    }

    //username추출(token 내 claim에 사용자 정보가 담겨있는지 확인)
    public static String getUserName(String token, String secretKey) {
        return extractClaims(token, secretKey).get("userName", String.class);
    }

    //토큰 만료 시 접근 거부
    public static boolean isExpired(String token, String key) {
        Date expiredDate = extractClaims(token, key).getExpiration();
        return expiredDate.before(new Date());
    }
}
