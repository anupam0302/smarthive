package com.smarthive.config;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SmarthiveConfig {

    @Bean
    LocalDateTime startupTime() {
		return LocalDateTime.now();
	}
}
