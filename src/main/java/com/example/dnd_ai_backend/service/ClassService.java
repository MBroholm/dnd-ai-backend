package com.example.dnd_ai_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.dnd_ai_backend.dto.character_class.ClassListResponse;
import com.example.dnd_ai_backend.dto.common.ApiReferenceDto;

@Service
public class ClassService {

    private WebClient dndClient;

    public ClassService(WebClient dndClient) {
        this.dndClient = dndClient;
    }

    public List<ApiReferenceDto> getAllClasses() {
        return dndClient.get()
                .uri("/api/2014/classes")
                .retrieve()
                .bodyToMono(ClassListResponse.class)
                .map(ClassListResponse::results)    
                .block();
    }

}
