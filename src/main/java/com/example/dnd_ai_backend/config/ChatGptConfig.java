package com.example.dnd_ai_backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Configuration
@Getter
@Setter
public class ChatGptConfig {
    @Value("${app.chatgpt.api-key}")
    private String apiKey;
    
    private String url = "https://api.openai.com/v1/chat/completions";
    private String model = "gpt-4o-mini";
    private Double temperature = 0.8;
    private Integer maxTokens = 500;
    private Double topP = 1.0;
    private Double frequencyPenalty = 0.0;
    private Double presencePenalty = 0.0;
}
