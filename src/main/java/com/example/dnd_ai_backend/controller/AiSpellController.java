package com.example.dnd_ai_backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.dnd_ai_backend.dto.chatgpt.ChatGptRequest;
import com.example.dnd_ai_backend.dto.chatgpt.ChatGptResponse;
import com.example.dnd_ai_backend.dto.spell.SpellDetailResponse;
import com.example.dnd_ai_backend.service.ChatGptService;
import com.example.dnd_ai_backend.service.SpellService;
import com.example.dnd_ai_backend.util.SpellFormatter;

@RestController
@RequestMapping("/spells")
public class AiSpellController {

    private final SpellService spellService;
    private final ChatGptService chatGptService;

    public AiSpellController(SpellService spellService, ChatGptService chatGptService) {
        this.spellService = spellService;
        this.chatGptService = chatGptService;
    }

    @GetMapping("/{index}/explain")
    public String explainSpell(@PathVariable String index) {

        // 1. Fetch spell details from the DnD API
        SpellDetailResponse spell = spellService.getSpellByIndex(index);
        String spellText = SpellFormatter.format(spell);

        // 2. Build the prompt
        String prompt = """
                You are an expert Dungeons & Dragons 5e rules explainer.
                Explain the following spell in clear, friendly language.
                Include:
                - what the spell does
                - how it feels to cast it
                - tactical uses
                - any hidden rules or edge cases players often miss

                Spell data:
                %s
                """.formatted(spellText);

        System.out.println("Prompt sent to ChatGPT:\n" + prompt);

        // 3. Build ChatGPT request
        ChatGptRequest.Message userMessage = new ChatGptRequest.Message("user", prompt);
        List<ChatGptRequest.Message> messages = List.of(userMessage);

        ChatGptResponse response = chatGptService.sendRequest(messages);

        System.out.println(response
                .getChoices()
                .get(0)
                .getMessage()
                .getContent());
                
        // 4. Return the AI's explanation
        return response
                .getChoices()
                .get(0)
                .getMessage()
                .getContent();
    }
}
