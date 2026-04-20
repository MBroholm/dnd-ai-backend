package com.example.dnd_ai_backend.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin(origins = "*")
public class AiSpellController {

    private final SpellService spellService;
    private final ChatGptService chatGptService;

    public AiSpellController(SpellService spellService, ChatGptService chatGptService) {
        this.spellService = spellService;
        this.chatGptService = chatGptService;
    }

    @GetMapping("/{index}/explanation")
    public String explainSpell(@PathVariable String index) {

        // 1. Fetch spell details from the DnD API
        SpellDetailResponse spell = spellService.getSpellByIndex(index);
        String spellText = SpellFormatter.format(spell);

        // 2. Build the prompt
        String prompt = """
                You are an expert Dungeons & Dragons 5e rules explainer.

                Write a clear, concise Markdown explanation of the following spell.
                Use the following structure and keep each section brief (2–4 sentences max).

                ### Spell Overview
                Summarize what the spell does in simple, accurate terms.

                ### How It Feels to Cast
                Describe the sensory or thematic feel of casting the spell.

                ### Tactical Uses
                Provide 3–5 practical tactical tips as bullet points.

                ### Hidden Rules or Edge Cases
                List any commonly misunderstood rules or interactions.

                Keep the entire explanation under 350–400 words.
                Do not add extra sections.

                Spell data:
                %s
                """.formatted(spellText);

        // 3. Build ChatGPT request
        ChatGptRequest.Message userMessage = new ChatGptRequest.Message("user", prompt);
        List<ChatGptRequest.Message> messages = List.of(userMessage);

        ChatGptResponse response = chatGptService.sendRequest(messages);

        // 4. Return the AI's explanation
        return response
                .getChoices()
                .get(0)
                .getMessage()
                .getContent();
    }
}
