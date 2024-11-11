package com.example.climserver.global.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.redis.repository.configuration.EnableRedisRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.example.climserver.domain.user.dao")     //JPA 리포지토리 패키지만 스캔하도록 설정
@EnableRedisRepositories(basePackages = "com.example.climserver.domain.auth.dao")   //Redis 리포지토리 패키지만 스캔하도록 설정
public class RepositoryConfig {
    //Redis 리포지토리와 JPA 리포지토리 bean 충돌 해결
}
