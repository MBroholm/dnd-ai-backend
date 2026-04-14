package com.example.dnd_ai_backend.controller;

import org.springframework.web.bind.annotation.RestController;

import com.example.dnd_ai_backend.dto.MonsterApiResponse;
import com.example.dnd_ai_backend.service.MonsterService;

import reactor.core.publisher.Mono;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/monsters")
public class MonsterController {
    
    private final MonsterService monsterService;

    public MonsterController(MonsterService monsterService) {
        this.monsterService = monsterService;
    }

    @GetMapping("/{index}")
    public Mono<ResponseEntity<MonsterApiResponse>> getMonster(@PathVariable String index) {
        return monsterService.getMonster(index)
                .map(ResponseEntity::ok)
                .defaultIfEmpty(ResponseEntity.notFound().build());
    }

}
