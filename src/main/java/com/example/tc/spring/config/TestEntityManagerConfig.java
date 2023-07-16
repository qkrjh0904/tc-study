package com.example.tc.spring.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Profile("test")
@Configuration
@EnableJpaAuditing
@EntityScan
@EnableJpaRepositories
@RequiredArgsConstructor
public class TestEntityManagerConfig {
}
