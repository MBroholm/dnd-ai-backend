package com.example.dnd_ai_backend.dto;

import java.util.List;

import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ActionApi(
        String name,
        String desc,
        Integer attackBonus,
        List<Damage> damage,
        String multiattackType,
        List<MultiattackAction> actions,
        Dc dc,
        Usage usage,
        Options options
) {}
