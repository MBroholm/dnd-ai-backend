package com.example.dnd_ai_backend.dto;

import java.util.List;

import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record LegendaryAction(
        String name,
        String desc,
        Dc dc,
        List<Damage> damage
) {}
