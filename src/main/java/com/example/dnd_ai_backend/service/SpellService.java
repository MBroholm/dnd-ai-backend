package com.example.dnd_ai_backend.service;

import java.time.Duration;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.dnd_ai_backend.dto.spell.SpellDetailResponse;
import com.example.dnd_ai_backend.dto.spell.SpellListResponse;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class SpellService {
    private static final Duration TTL = Duration.ofHours(24);

    private final WebClient dndClient;

    private final Flux<SpellDetailResponse> cachedSpellFlux;
    private final Mono<Map<String, SpellDetailResponse>> cachedSpellMap;

    public SpellService(@Qualifier("dndClient") WebClient dndClient) {
        this.dndClient = dndClient;

        this.cachedSpellFlux = loadAllSpellsReactive()
                .cache(TTL);

        this.cachedSpellMap = cachedSpellFlux
                .collectMap(SpellDetailResponse::index)
                .cache(TTL);
    }

    public List<SpellDetailResponse> getAllSpells() {
        return cachedSpellFlux.collectList().block();
    }

    public Flux<SpellDetailResponse> getAllSpellsReactive() {
        return cachedSpellFlux;
    }

    public SpellDetailResponse getSpellByIndex(String index) {
        return getSpellByIndexReactive(index).block();
    }

    public Mono<SpellDetailResponse> getSpellByIndexReactive(String index) {
        return cachedSpellMap
                .flatMap(map -> {
                    SpellDetailResponse spell = map.get(index);
                    if (spell != null) {
                        return Mono.just(spell);
                    } else {
                        return fetchSpellFromApi(index);
                    }
                });
    }

    private Mono<SpellDetailResponse> fetchSpellFromApi(String index) {
        return dndClient.get()
                .uri("/api/2014/spells/{index}", index)
                .retrieve()
                .bodyToMono(SpellDetailResponse.class);
    }

    private Flux<SpellDetailResponse> loadAllSpellsReactive() {
        return dndClient.get()
                .uri("/api/2014/spells")
                .retrieve()
                .bodyToMono(SpellListResponse.class)
                .flatMapMany(list -> Flux.fromIterable(list.results()))
                .flatMap(spell -> fetchSpellFromApi(spell.index())); // PARALLEL
    }

}
