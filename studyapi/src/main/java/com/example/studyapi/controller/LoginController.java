package com.example.studyapi.controller;

import com.example.studyapi.form.KakaoApi;
import com.example.studyapi.service.KakaoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.util.HashMap;

@Controller
@RequiredArgsConstructor
@Slf4j
public class LoginController {

    private final KakaoApi kakaoApi;
    private final KakaoService kakaoService;

    @GetMapping("/login")
    public String loginPage(Model model) {
        //버튼 클릭시 이동하는 주소
        String location = "https://kauth.kakao.com/oauth/authorize?response_type=code&client_id="+kakaoApi.getKakaoApiKey()+"&redirect_uri="+kakaoApi.getKakaoRedirectUri();
        model.addAttribute("location", location);

        return "login";
    }

    @GetMapping("/login/oauth2/code/kakao")
    public String callback(@RequestParam("code") String code,Model model) throws IOException {
        String accessToken = kakaoService.getAccessTokenFromKakao(kakaoApi.getKakaoApiKey(), code);
        HashMap<String, Object> userInfo = kakaoService.getUserInfo(accessToken);
        log.info("id : " + userInfo.get("id"));
        model.addAttribute("id", userInfo.get("id"));
        model.addAttribute("nickname", userInfo.get("nickname"));
        // User 로그인, 또는 회원가입 로직 추가
        return "info";
    }

}
