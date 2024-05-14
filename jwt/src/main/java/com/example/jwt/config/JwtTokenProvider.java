package com.example.jwt.config;

import com.example.jwt.token.JwtToken;
import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Arrays;
import java.util.Collection;
import java.util.Date;
import java.util.stream.Collectors;

@Slf4j
@Component
public class JwtTokenProvider {
    private final Key key;

    public JwtTokenProvider(@Value("${jwt.secret}") String secretKey) {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        this.key = Keys.hmacShaKeyFor(keyBytes);
    }

    /**
     * Member의 정보로 AccessToken과 RefreshToken을 생성하는 메서드
     * 인증 객체 기반으로 AccessToken, RefreshToken 생성
     * Access Token: 인증된 사용자의 권한 정보와 만료시간을 담고 있음
     * Refresh Token: Access Token의 갱신을 위해 사용
     */
    public JwtToken generateToken(Authentication authentication) {
        //권한 가져오기
        String authorities = authentication.getAuthorities().stream()
                .map(GrantedAuthority::getAuthority)
                .collect(Collectors.joining(","));

        long now = (new Date()).getTime();

        //Access Token 생성
        Date accessTokenExpiresln = new Date(now + 86400000);
        String accessToken = Jwts.builder()
                .setSubject(authentication.getName())
                .claim("auth",authorities)
                .setExpiration(accessTokenExpiresln)
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        //Refresh Token 생성
        String refreshToken = Jwts.builder()
                .setExpiration(new Date(now + 86400000))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();

        return JwtToken.builder()
                .grantType("Bearer")
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
    }

    /**
     *  JWT 토큰을 복호화해 토큰에 들어있는 정보를 꺼내는 메서드
     *  Access Token을 복호화해 사용자의 인증 정보를 생성
     *  토큰의 Claims에서 권한 정보를 추출하고 User 객체를 생성해 Authentication 객체로 반환
     *  Authentication 객체 생성 과정
     *  토큰의 클래임에서 권한 정보를 가져온다. auth 클레임은 토큰에 저장된 권한 정보를 나타낸다.
     *  가져온 권한 정보를 SimpleGrantedAuthority 객체로 변환해 컬렉션에 추가한다.
     *  UserDetails 객체를 생성해 주체와 권한 정보, 기타 필요한 정보를 설정
     *  UsernamePasswordAuthenticationToken 객체를 생성해 주체와 권한 정보를 포함한 인증객체 생성
     * @param accessToken
     * @return
     */
    public Authentication getAuthentication(String accessToken) {
        //jwt 토큰 복호화
        Claims claims = parseClaims(accessToken);

        if (claims.get("auth") == null) {
            throw new RuntimeException("권한 정보가 없는 토큰입니다.");
        }
        //클래임에서 권한 정보 가져오기
        //Collection<? extends GrantedAuthority>은 권한 정보를 다양한 타입의 객체로 처리 가능해 유연성과 확장성을 얻을 수 있다.
        Collection<? extends GrantedAuthority> authorities = Arrays.stream(claims.get("auth").toString().split(","))
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toList());

        //UserDetails 객체를 만들어서 Authentication return
        //UserDetails: interface, User: UserDetails를 구현한 class
        UserDetails principal = new User(claims.getSubject(), "",authorities);
        return new UsernamePasswordAuthenticationToken(principal,"",authorities);
    }

    /**
     * 토큰 정보를 검증하는 메서드
     * Jwts.parserBuilder로 토큰의 서명 키를 설정하고 예외 처리를 통해 토큰의 유효성 여부 판단
     * IllegalArgumentException -> 토큰이 올바른 형식이 아니거나 클레임이 비어있는 경우등 발생
     * @param token
     * @return
     */
    public boolean validateToken(String token) {
        try {
            Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);
            return true;
        } catch (SecurityException | MalformedJwtException e) {
        log.info("Invalid JWT Token", e);
    } catch (ExpiredJwtException e) {
        log.info("Expired JWT Token", e);
    } catch (UnsupportedJwtException e) {
        log.info("Unsupported JWT Token", e);
    } catch (IllegalArgumentException e) {
        log.info("JWT claims string is empty.", e);
    }
        return false;
    }

    /**
     * accessToken
     * Claims - 토큰에서 사용할 정보의 조각
     * 주어진 Access Token을 복호화하고 만료된 토큰의 경우에도 Claims 반환
     * parseClaimsJws - JWT 토큰의 검증과 파싱을 모두 수행
     * @param accessToken
     * @return
     */
    private Claims parseClaims(String accessToken) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(accessToken)
                    .getBody();
        } catch (ExpiredJwtException e) {
            return e.getClaims();
        }
    }




}





