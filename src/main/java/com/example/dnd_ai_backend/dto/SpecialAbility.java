package com.example.dnd_ai_backend.dto;

import java.util.List;

import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record SpecialAbility(
        String name,
        String desc,
        Usage usage,
        List<Damage> damage
) {}
