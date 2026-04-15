package com.example.dnd_ai_backend.dto.common;

import java.util.Map;

import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record DamageDto(
        ApiReferenceDto damageType,
        Map<String, String> damageAtSlotLevel
) {}

