package com.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(scanBasePackages = "com.project")
//@ComponentScan(basePackages = {
//        "new-core.database.database-mysql",
//        "new-core.domain",
//        "new-core.infra",
//        "new-core.interceptor",
//        "application.dto",
//        "application.web",
//        "global-utils",
//})
//@EntityScan(basePackages = "new-core.domain.com.base") // Entity 패키지 경로
//@EnableJpaRepositories(basePackages = "new-core.database.database-mysql.com.repository") // Repository 패키지 경로
public class MainWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(MainWebApplication.class, args);
    }
}
