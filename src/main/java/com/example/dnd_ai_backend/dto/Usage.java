package com.example.dnd_ai_backend.dto;

import java.util.List;

import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record Usage(
        String type,
        Integer times,
        List<String> restTypes,
        String dice,
        Integer minValue
) {}
