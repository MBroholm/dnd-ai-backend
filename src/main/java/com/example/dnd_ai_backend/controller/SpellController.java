package com.example.dnd_ai_backend.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dnd_ai_backend.dto.spell.SpellDetailResponse;
import com.example.dnd_ai_backend.dto.spell.SpellListResponse;
import com.example.dnd_ai_backend.service.SpellService;

@RestController
@RequestMapping("/spells")
public class SpellController {

    private final SpellService spellService;

    public SpellController(SpellService spellService) {
        this.spellService = spellService;
    }

    @GetMapping
    public SpellListResponse getAllSpells() {
        return spellService.getAllSpells();
    }

    @GetMapping("/{index}")
    public SpellDetailResponse getSpellByIndex(@PathVariable String index) {
        return spellService.getSpellByIndex(index);
    }
}

