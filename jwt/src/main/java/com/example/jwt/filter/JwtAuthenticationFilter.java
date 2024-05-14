package com.example.jwt.filter;

import com.example.jwt.config.JwtTokenProvider;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.GenericFilterBean;

import javax.print.attribute.standard.PrinterURI;
import java.io.IOException;

@RequiredArgsConstructor
public class JwtAuthenticationFilter extends GenericFilterBean {
    private final JwtTokenProvider jwtTokenProvider;

    /**
     * resolveToken 메서드를 사용해 요청 헤더에서 JWT 토큰 추출
     * JwtTokenProvider의 validateToken 메서드로 JWT 토큰의 유효성 검증
     * 토큰이 유효하면 JwtTokenProvider의 getAuthentication 메서드로 인증 객체를 가져와서 SecurityContext에 저장
     * 요청을 처리하는 동안 인증 정보는 유지 됨
     * filterChain.dofilter를 호출해 다음 필터로 요청을 전달
     * @param request
     * @param response
     * @param filterChain
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws IOException, ServletException {
        //Request Header에서 JWT 토큰 추출
        String token = resolveToken((HttpServletRequest) request);

        //validateToken으로 토큰 유효성 검사
        if (token != null && jwtTokenProvider.validateToken(token)) {
            //토큰이 유효할 경우 토큰에서 Authentication 객체를 가지고 와서 SecurityContext에 저장
            Authentication authentication = jwtTokenProvider.getAuthentication(token);
            SecurityContextHolder.getContext().setAuthentication(authentication);
        }
        filterChain.doFilter(request,response);
    }

    /**
     * 주어진 HttpServletRequest에서 토큰 정보를 추출하는 역할
     * "Authorization" 헤더에서 "Bearer" 접두사로 시작하는 토큰을 추출해 반환
     * @param request
     * @return
     */
    //Request Header에서 토큰 정보 추출
    private String resolveToken(HttpServletRequest request) {
        String bearerToken = request.getHeader("Authorization");
        if (StringUtils.hasText(bearerToken) && bearerToken.startsWith("Bearer")) {
            return bearerToken.substring(7);
        }
        return null;
    }
}

