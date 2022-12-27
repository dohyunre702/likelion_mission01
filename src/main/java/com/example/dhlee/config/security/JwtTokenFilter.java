package com.example.dhlee.config.security;

import com.example.dhlee.service.impl.UserServiceImpl;
import com.example.dhlee.util.JwtTokenUtil;
import com.google.common.net.HttpHeaders;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
public class JwtTokenFilter extends OncePerRequestFilter {

    private final UserServiceImpl userService;
    private final String secretKey;

    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain filterChain) throws ServletException, IOException {

        UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                "", null, List.of(
                new SimpleGrantedAuthority("USER")));
        authenticationToken.setDetails(
                new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        filterChain.doFilter(request, response);

        //header 꺼내기
        final String authorizationHeader = request.getHeader(HttpHeaders.AUTHORIZATION);

        //인가 불가능 1. null(인증 헤더가 잘못된 값을 가진 경우)
        if (authorizationHeader == null || !authorizationHeader.startsWith("Bearer")) {
            filterChain.doFilter(request, response);
            return;
        }

        //인가 불가능 2. 유효기간 만료
        String token;
        try {//header에서 token 분리
            token = authorizationHeader.split(" ")[1].trim();
            //token 유효성 체크
            JwtTokenUtil.isExpired(token, secretKey);
        } catch (Exception e) {
            //"token 추출 실패"
            filterChain.doFilter(request, response);
            return;
        }

        //인가 불가능 3. 접근 권한 부적절
        String userName = JwtTokenUtil.getUserName(token, secretKey);
        //User user = userService.;

        //Detail 넣어주기
        authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
        SecurityContextHolder.getContext().setAuthentication(authenticationToken); //권한 부여 완료
        filterChain.doFilter(request, response);
    }
}