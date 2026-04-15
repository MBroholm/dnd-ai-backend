package com.example.dnd_ai_backend.dto.spell;

import java.util.List;

import com.example.dnd_ai_backend.dto.common.ApiReferenceDto;
import com.example.dnd_ai_backend.dto.common.AreaOfEffectDto;
import com.example.dnd_ai_backend.dto.common.DamageDto;
import com.example.dnd_ai_backend.dto.common.DcDto;

import tools.jackson.databind.PropertyNamingStrategies;
import tools.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record SpellDetailResponse(
        String index,
        String name,
        List<String> desc,
        List<String> higherLevel,
        String range,
        List<String> components,
        String material,
        boolean ritual,
        String duration,
        boolean concentration,
        String castingTime,
        int level,
        DamageDto damage,
        DcDto dc,
        AreaOfEffectDto areaOfEffect,
        ApiReferenceDto school,
        List<ApiReferenceDto> classes,
        List<ApiReferenceDto> subclasses,
        String url,
        String updatedAt
) {}

