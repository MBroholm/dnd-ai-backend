package com.example.dnd_ai_backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.dnd_ai_backend.config.ChatGptConfig;
import com.example.dnd_ai_backend.dto.chatgpt.ChatGptRequest;
import com.example.dnd_ai_backend.dto.chatgpt.ChatGptResponse;

@Service
public class ChatGptService {
    private final WebClient chatGptClient;
    private final ChatGptConfig config;

    public ChatGptService(@Qualifier("chatGptClient") WebClient chatGptClient, ChatGptConfig config) {
        this.chatGptClient = chatGptClient;
        this.config = config;
    }

    public ChatGptResponse sendRequest(ChatGptRequest request) {
        return chatGptClient.post()
                .bodyValue(request)
                .retrieve()
                .bodyToMono(ChatGptResponse.class)
                .block();
    }

    public ChatGptResponse sendRequest(List<ChatGptRequest.Message> messages) {

        ChatGptRequest request = new ChatGptRequest();
        request.setModel(config.getModel());
        request.setMessages(messages);
        request.setTemperature(config.getTemperature());
        request.setMaxTokens(config.getMaxTokens());
        request.setTopP(config.getTopP());
        request.setFrequencyPenalty(config.getFrequencyPenalty());
        request.setPresencePenalty(config.getPresencePenalty());

        return sendRequest(request);
    }
}
