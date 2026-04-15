package com.example.dnd_ai_backend.dto.spell;

import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record SpellListEntry(
        String index,
        String name,
        int level,
        String url
) {}

