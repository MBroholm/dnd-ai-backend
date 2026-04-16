package com.example.dnd_ai_backend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.dnd_ai_backend.dto.spell.SpellDetailResponse;
import com.example.dnd_ai_backend.dto.spell.SpellListResponse;

@Service
public class SpellService {
    private final WebClient dndClient;

    public SpellService(WebClient dndClient) {
        this.dndClient = dndClient;
    }

    public SpellListResponse getAllSpells() {
        return dndClient.get()
                .uri("/api/2014/spells")
                .retrieve()
                .bodyToMono(SpellListResponse.class)
                .block();
    }

    public SpellDetailResponse getSpellByIndex(String index) {
        return dndClient.get()
                .uri("/api/2014/spells/{index}", index)
                .retrieve()
                .bodyToMono(SpellDetailResponse.class)
                .block();
    }

}
