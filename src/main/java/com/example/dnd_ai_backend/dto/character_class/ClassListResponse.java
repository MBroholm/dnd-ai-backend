package com.example.dnd_ai_backend.dto.character_class;

import java.util.List;

import com.example.dnd_ai_backend.dto.common.ApiReferenceDto;

public record ClassListResponse(int count,
        List<ApiReferenceDto> results) {

}
