package com.example.dnd_ai_backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dnd_ai_backend.dto.chatgpt.ChatGptRequest;
import com.example.dnd_ai_backend.service.AiSpellService;

@RestController
@RequestMapping("/spells")
@CrossOrigin(origins = "*")
public class AiSpellController {

    private final AiSpellService aiSpellService;

    public AiSpellController(AiSpellService aiSpellService) {
        this.aiSpellService = aiSpellService;
    }

    @GetMapping("/{index}/explanation")
    public String getSpellExplanation(@PathVariable String index) {
        return aiSpellService.getSpellExplanation(index);
    }

    @PostMapping("/{index}/chat")
    public String chatAboutSpell(
            @PathVariable String index,
            @RequestBody List<ChatGptRequest.Message> messages) {
        return aiSpellService.chatAboutSpell(index, messages);
    }
}
