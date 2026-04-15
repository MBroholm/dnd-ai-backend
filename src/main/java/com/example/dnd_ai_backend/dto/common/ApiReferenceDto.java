package com.example.dnd_ai_backend.dto.common;

import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ApiReferenceDto(
        String index,
        String name,
        String url
) {}

