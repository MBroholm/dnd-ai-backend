package com.example.dnd_ai_backend.service;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.dnd_ai_backend.dto.MonsterApiResponse;

import reactor.core.publisher.Mono;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class MonsterService {

    private final WebClient dndClient;
    private final Map<String, MonsterApiResponse> cache = new ConcurrentHashMap<>();

    public MonsterService(@Qualifier("dndClient") WebClient dndClient) {
        this.dndClient = dndClient;
    }

    public Mono<MonsterApiResponse> getMonster(String index) {

        if (cache.containsKey(index)) {
            return Mono.just(cache.get(index));
        }

        return dndClient.get()
                .uri("/api/2014/monsters/{index}", index)
                .retrieve()
                .bodyToMono(MonsterApiResponse.class)
                .doOnNext(monster -> cache.put(index, monster));
    }

    public void clearCache() {
        cache.clear();
    }
}
