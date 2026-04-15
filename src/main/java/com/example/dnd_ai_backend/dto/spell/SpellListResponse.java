package com.example.dnd_ai_backend.dto.spell;

import java.util.List;

import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record SpellListResponse(
        int count,
        List<SpellListEntry> results
) {}
