package com.example.jwt.controller;

import com.example.jwt.domain.MemberDto;
import com.example.jwt.domain.SignInDto;
import com.example.jwt.domain.SignUpDto;
import com.example.jwt.repository.MemberRepository;
import com.example.jwt.service.MemberService;
import com.example.jwt.token.JwtToken;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.*;

import static org.assertj.core.api.Assertions.assertThat;


//EmbeddedWebApplicationContex를 로드하여 실제 서블릿 활경 구성, 임의의 port listen
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)

class MemberControllerTest {

    @Autowired
    MemberService memberService;
    @Autowired
    MemberRepository memberRepository;
    @Autowired
    TestRestTemplate testRestTemplate;
    @LocalServerPort
    int randomServerPort;

    private SignUpDto signUpDto;

    @BeforeEach
    void beforeEach() {
        // Member 회원가입
        signUpDto = SignUpDto.builder()
                .username("member")
                .password("12345678")
                .nickname("닉네임")
                .address("서울시 광진구")
                .phone("010-1234-5678")
                .build();
    }

    @AfterEach
    void afterEach() {
        memberRepository.deleteAll();
    }

    @Test
    public void signUpTest() {

        // API 요청 설정
        String url = "http://localhost:" + randomServerPort + "/members/sign-up";
        ResponseEntity<MemberDto> responseEntity = testRestTemplate.postForEntity(url, signUpDto, MemberDto.class);

        // 응답 검증
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        MemberDto savedMemberDto = responseEntity.getBody();
        assertThat(savedMemberDto.getUsername()).isEqualTo(signUpDto.getUsername());
        assertThat(savedMemberDto.getNickname()).isEqualTo(signUpDto.getNickname());
    }
    @Test
    public void signInTest() {
        memberService.signUp(signUpDto);

        SignInDto signInDto = SignInDto.builder()
                .username("member")
                .password("12345678").build();

        // 로그인 요청
        JwtToken jwtToken = memberService.signIn(signInDto.getUsername(),signInDto.getPassword());

        // HttpHeaders 객체 생성 및 토큰 추가
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setBearerAuth(jwtToken.getAccessToken());
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);


        // API 요청 설정
        String url = "http://localhost:" + randomServerPort + "/members/test";
        ResponseEntity<String> responseEntity = testRestTemplate.postForEntity(url, new HttpEntity<>(httpHeaders), String.class);
        assertThat(responseEntity.getStatusCode()).isEqualTo(HttpStatus.OK);
        assertThat(responseEntity.getBody()).isEqualTo(signInDto.getUsername());



    }

}