package com.example.dnd_ai_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class WebClientConfig {

    @Bean
    public WebClient.Builder webClientBuilder() {
        return WebClient.builder();
    }

    @Bean
    public WebClient dndClient(WebClient.Builder builder) {
        return builder
                .baseUrl("https://www.dnd5eapi.co")
                .build();
    }

    @Bean
    public WebClient chatGptClient(WebClient.Builder builder, ChatGptConfig config) {
        return builder
                .baseUrl(config.getUrl())
                .defaultHeader("Authorization", "Bearer " + config.getApiKey())
                .build();
    }
}
