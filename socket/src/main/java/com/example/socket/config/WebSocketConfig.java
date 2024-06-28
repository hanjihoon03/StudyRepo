package com.example.socket.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@RequiredArgsConstructor
@Configuration
@EnableWebSocket// WebSocket을 활성화하는 스프링 어노테이션
public class WebSocketConfig implements WebSocketConfigurer {
    // WebSocket 핸들러 주입
    private final WebSocketHandler webSocketHandler;
    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        // WebSocket 핸들러를 등록
        registry.addHandler(webSocketHandler, "ws/chat")
                // 모든 출처에서 오는 요청을 허용
                .setAllowedOrigins("*");
    }
}
