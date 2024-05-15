package com.example.cacheTest.config;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@EnableCaching
@Configuration
public class CacheConfig {

    @Bean
    public CacheManager cacheManager() {
        // 내부적으로 ConcurrentHashMap을 사용하여 캐시를 관리
        ConcurrentMapCacheManager cacheManager = new ConcurrentMapCacheManager();
        // 캐시 매니저가 null 값을 캐시에 저장하는 것을 허용하지 않도록 설정합니다. 기본적으로 이 옵션은 false로 설정되어 있어 null 값을 캐시에 저장하지 않는다.
        cacheManager.setAllowNullValues(false);
        // 캐시 매니저에 사용할 캐시 이름을 설정합니다.
        cacheManager.setCacheNames(List.of("members"));
        return cacheManager;
    }
}
