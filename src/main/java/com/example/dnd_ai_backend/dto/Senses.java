package com.example.dnd_ai_backend.dto;

import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record Senses(
        String blindsight,
        String darkvision,
        Integer passivePerception
) {}
