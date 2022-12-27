package com.example.dhlee.config.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Date;
import java.util.List;

public class JwtTokenProvider {

    //userDetailsService DI
    private final UserDetailsService userDetailsService;

    public JwtTokenProvider(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Value("${springboot.jwt.secret}")
    private String secretKey = "secretKey";
    private final long tokenValid = 1000L * 60 * 60l;

    @PostConstruct
    protected void init() { //TokenProvider 내 secretKey 초기화
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes(StandardCharsets.UTF_8));
    }

    //토큰 생성
    public String createToken(String userUid, List<String> roles) {
        Claims claims = Jwts.claims().setSubject(userUid);
        claims.put("roles", roles);
        Date now = new Date();

        String token = Jwts.builder() //토큰 생성
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + tokenValid))
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();

        return token; //생성 완료
    }
    //토큰 기반 회원 구별정보 추출
    public String getUsername(String token) {
        String info = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().getSubject();
        return info;
    }

    //토큰 인증정보 조회
    public Authentication getAuthentication(String token) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(this.getUsername(token));
        return new UsernamePasswordAuthenticationToken(userDetails, "", userDetails.getAuthorities());
    }

    //http헤더에서 Token값 추출
    public String resolveToken(HttpServletRequest request) {
        return request.getHeader("X-AUTH-TOKEN");
    }

    //토큰 유효 체크
    public boolean validateToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token);
            return !claims.getBody().getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }
}
